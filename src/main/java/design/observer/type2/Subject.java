package design.observer.type2;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 抽象主题
 */
public abstract class Subject {
    /**
     * 保存所有观察者对象引用
     */
    private Vector observersVectors = new Vector();

    public void attach(Observer observer) {
        observersVectors.addElement(observer);
    }

    public void detach(Observer observer) {
        observersVectors.removeElement(observer);
    }

    public void notifyObservers() {
        Enumeration enumeration = observers();
        while (enumeration.hasMoreElements()) {
            ((Observer) enumeration.nextElement()).update();
        }
    }

    public Enumeration observers() {
        return ((Vector) observersVectors.clone()).elements();
    }
}
