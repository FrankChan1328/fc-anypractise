package design.bridge.casesairplane.plane;

import design.bridge.casesairplane.planemaker.AirplaneMaker;

/**
 * 修正抽象化角色：载货飞机
 */
public class CargoPlane extends Airplane{

    public CargoPlane(AirplaneMaker airplaneMaker) {
        super(airplaneMaker);
    }

    @Override
    public void fly() {
        airplaneMaker.produce();
        System.out.println("载货飞机...");
    }
}
