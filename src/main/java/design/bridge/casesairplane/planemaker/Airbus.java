package design.bridge.casesairplane.planemaker;

/**
 * 具体实现化角色：空客
 */
public class Airbus extends AirplaneMaker {

    @Override
    public void produce() {
        System.out.println("Airbus produce...");
    }
}
