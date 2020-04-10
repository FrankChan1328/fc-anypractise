package design.prototype.register;

public class ConcretePrototype implements Prototype {

    /**
     * synchronized 修饰方法时，锁定的是调用这个同步方法的对象，通常是一个对象在不同线程中；
     * 等价于:
     * public Object clone(){
     *      synchronized (this){ 
     *      }
     * }
     */
    public synchronized Object clone() {
        Prototype temp = null;
        try {
            temp = (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
