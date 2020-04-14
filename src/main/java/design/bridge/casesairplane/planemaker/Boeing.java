package design.bridge.casesairplane.planemaker;

/**
 * 具体实现化角色：波音
 */
public class Boeing extends AirplaneMaker {

    @Override
    public void produce() {
        System.out.println("Boeing produce...");
    }
}
