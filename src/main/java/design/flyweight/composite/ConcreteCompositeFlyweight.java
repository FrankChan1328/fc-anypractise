package design.flyweight.composite;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import design.flyweight.Flyweight;

public class ConcreteCompositeFlyweight extends Flyweight {
    private HashMap<Character, Flyweight> flies = new HashMap<>(10);

    private Flyweight flyweight;

    public ConcreteCompositeFlyweight() {
    }

    public void add(Character key, Flyweight fly) {
        flies.put(key, fly);
    }

    public void operation(String extrinsicState) {
        Flyweight fly = null;

        for (Iterator<Entry<Character, Flyweight>> it = flies.entrySet().iterator(); it.hasNext();) {
            Entry<Character, Flyweight> e = it.next();
            fly = (Flyweight) e.getValue();
            fly.operation(extrinsicState);
        }
    }
}