package edu.spu.se411.lab08;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Random;

public class App {

    static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        logger.info("Application is starting...");

        // Create sensors
        TemperatureSensor temp = new TemperatureSensor();
        HumiditySensor humidity = new HumiditySensor();
        // Create observers
        Observer dashboard = new DashboardObserver();
        Observer loggerObserver = new LoggerObserver();

        // Register observers
        temp.register(dashboard);
        temp.register(loggerObserver);

        humidity.register(dashboard);
        humidity.register(loggerObserver);

        // Simulate sensor readings
        Random random = new Random();

        for (int i = 0; i < 10; i++) {

            temp.setReading(20 + random.nextDouble() * 15);
            humidity.setReading(40 + random.nextDouble() * 20);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Test cloning
        System.out.println("\n--- Testing Sensor Clone ---");

        TemperatureSensor clonedTemp =
                (TemperatureSensor) temp.clone();

        System.out.println("Changing cloned sensor reading...");
        clonedTemp.setReading(30.0);

        System.out.println(
                "No observer message should appear above because the clone has no observers."
        );

        clonedTemp.register(dashboard);

        System.out.println("After registering dashboard to clone:");
        clonedTemp.setReading(35.0);

        logger.info("Application is stopping...");
    }
}