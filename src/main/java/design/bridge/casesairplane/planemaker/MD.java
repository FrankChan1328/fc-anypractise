package design.bridge.casesairplane.planemaker;

/**
 * 具体实现化角色：麦道
 */
public class MD extends AirplaneMaker {

    @Override
    public void produce() {
        System.out.println("MD produce...");
    }
}
