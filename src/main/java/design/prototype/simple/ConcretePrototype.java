package design.prototype.simple;

public class ConcretePrototype implements Prototype {
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            //
            return null;
        }
    }
}
