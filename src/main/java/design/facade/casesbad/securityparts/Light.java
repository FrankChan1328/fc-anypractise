package design.facade.casesbad.securityparts;

public class Light {
    public void turnOn() {
        System.out.println("Turning on the Light.");
    }

    public void turnOff() {
        System.out.println("Turning off the Light.");
    }

    public void changeBulb() {
        System.out.println("changing the light-bulb.");
    }
}