package design.bridge.casesairplane;

import design.bridge.casesairplane.plane.Airplane;
import design.bridge.casesairplane.plane.CargoPlane;
import design.bridge.casesairplane.plane.PassengerPlane;
import design.bridge.casesairplane.planemaker.AirplaneMaker;
import design.bridge.casesairplane.planemaker.Boeing;
import design.bridge.casesairplane.planemaker.MD;

public class Client {

    public static void main(String[] args) {
        // 麦道载客飞机
        AirplaneMaker md = new MD();
        Airplane passengerMd = new PassengerPlane(md);
        passengerMd.fly();
        
        // 波音载货飞机
        AirplaneMaker boeing = new Boeing();
        Airplane cargoBoeing = new CargoPlane(boeing);
        cargoBoeing.fly();
    }

}
