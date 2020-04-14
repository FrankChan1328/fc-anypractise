package design.bridge.casesairplane.plane;

import design.bridge.casesairplane.planemaker.AirplaneMaker;

/**
 * 修正抽象化角色：载客飞机
 * 
 */
public class PassengerPlane extends Airplane{

    public PassengerPlane(AirplaneMaker airplaneMaker) {
        super(airplaneMaker);
    }

    @Override
    public void fly() {
        airplaneMaker.produce();
        System.out.println("载客飞机...");
    }
}
