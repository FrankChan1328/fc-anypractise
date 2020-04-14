package design.bridge.casesairplane.plane;

import design.bridge.casesairplane.planemaker.AirplaneMaker;

/**
 * 抽象化角色
 */
public abstract class Airplane {
    protected AirplaneMaker airplaneMaker;

    public Airplane(AirplaneMaker airplaneMaker) {
        this.airplaneMaker = airplaneMaker;
    }

    public abstract void fly();
}
