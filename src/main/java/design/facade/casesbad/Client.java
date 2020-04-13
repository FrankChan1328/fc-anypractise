package design.facade.casesbad;

import design.facade.casesbad.securityparts.Alarm;
import design.facade.casesbad.securityparts.Camera;
import design.facade.casesbad.securityparts.Light;
import design.facade.casesbad.securityparts.Sensor;

public class Client {
    static private Camera camera1 = new Camera();
    static private Camera camera2 = new Camera();
    static private Light light1 = new Light();
    static private Light light2 = new Light();
    static private Light light3 = new Light();
    static private Sensor sensor = new Sensor();
    static private Alarm alarm = new Alarm();

    public static void main(String[] args) {
        camera1.turnOn();
        camera2.turnOn();

        light1.turnOn();
        light2.turnOn();
        light3.turnOn();

        sensor.activate();
        alarm.activate();
    }

}