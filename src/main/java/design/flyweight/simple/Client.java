package design.flyweight.simple;

import design.flyweight.Flyweight;

public class Client {
    private static FlyweightFactory factory;

    public static void main(String[] args) {
        factory = new FlyweightFactory();

        Flyweight fly = factory.factory(new Character('a'));
        fly.operation("First Call");

        fly = factory.factory(new Character('b'));
        fly.operation("Second Call");
        
        // 客户端创建了两个对象a 其实是共享了一个对象
        fly = factory.factory(new Character('a'));
        fly.operation("Third Call");

        // intrinsic Flyweight
        factory.checkFlyweight();
    }
}
