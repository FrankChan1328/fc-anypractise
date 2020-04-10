package design.prototype.register;

public class Client {
    private PrototypeManager mgr;
    private Prototype prototype;

    /**
     * 创建一份prototype，并拷贝一份存入原型管理器中
     */
    public void registerPrototyper() {
        prototype = new ConcretePrototype();
        Prototype copytype = (Prototype) prototype.clone();

        mgr.add(copytype);
    }
}