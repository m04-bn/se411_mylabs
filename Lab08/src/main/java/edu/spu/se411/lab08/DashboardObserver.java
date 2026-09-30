package edu.spu.se411.lab08;

public class DashboardObserver implements Observer {

    @Override
    public void update(Subject subject) {
        Sensor sensor = (Sensor) subject;

        System.out.printf(
            "Dashboard: %s reading changed to %.2f%n",
            sensor,
            sensor.getReading()
        );
    }
}