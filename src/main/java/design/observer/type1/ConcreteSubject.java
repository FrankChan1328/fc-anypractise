package design.observer.type1;

import java.util.Enumeration;
import java.util.Vector;

public class ConcreteSubject implements Subject {
    private Vector observersVectors = new Vector();

    @Override
    public void attach(Observer observer) {
        observersVectors.addElement(observer);
    }

    @Override
    public void detach(Observer observer) {
        observersVectors.removeElement(observer);
    }

    @Override
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
