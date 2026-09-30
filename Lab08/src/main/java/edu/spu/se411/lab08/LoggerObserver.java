package edu.spu.se411.lab08;

public class LoggerObserver implements Observer {

    @Override
    public void update(Subject subject) {
        Sensor sensor = (Sensor) subject;

        System.out.printf(
            "Logger: %s reading changed to %.2f%n",
            sensor,
            sensor.getReading()
        );
    }
}