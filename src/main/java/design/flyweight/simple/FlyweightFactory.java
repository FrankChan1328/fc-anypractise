package design.flyweight.simple;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import design.flyweight.ConcreteFlyweight;

import design.flyweight.Flyweight;

/**
 * 核心是FlyweightFactory，采取的是登记的工厂方式，用HashMap存储已经构造的ConcreteFlyweight。
 * 调用时先去查看HashMap是否已经存在，已存在则直接调用。不存在时先创建再添加到HashMap中以共享使用。
 */
public class FlyweightFactory {
    private HashMap<Character, Flyweight> flies = new HashMap<>();
    private Flyweight lnkFlyweight;

    public FlyweightFactory() {
    }

    public synchronized Flyweight factory(Character state) {
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
        System.out.println("==========checkFlyweight()=============");
    }
}