package design.flyweight.composite;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import design.flyweight.ConcreteFlyweight;
import design.flyweight.Flyweight;

public class FlyweightFactory {

    private HashMap<Character, Flyweight> flies = new HashMap<>();
    private Flyweight lnkFlyweight;

    public FlyweightFactory() {
    }

    public Flyweight factory(String compositeState) {
        ConcreteCompositeFlyweight compositeFly = new ConcreteCompositeFlyweight();
        int length = compositeState.length();
        Character state = null;

        for (int i = 0; i < length; i++) {
            state = new Character(compositeState.charAt(i));
            System.out.println("factory(" + state + ")");
            compositeFly.add(state, this.factory(state));
        }
        return compositeFly;
    }

    public Flyweight factory(Character state) {
        if (flies.containsKey(state)) {
            return (Flyweight) flies.get(state);
        } else {
            Flyweight fly = new ConcreteFlyweight(state);
            flies.put(state, fly);
            return fly;
        }
    }

    public void checkFlyweight() {
        Flyweight fly;
        int i = 0;

        System.out.println("\n==========checkFlyweight()=============");
        for (Iterator<Entry<Character, Flyweight>> it = flies.entrySet().iterator(); it.hasNext();) {
            Entry<Character, Flyweight> e = it.next();
            System.out.println("Item " + (++i) + " : " + e.getKey());
        }
        System.out.println("\n==========checkFlyweight()=============");
    }
}