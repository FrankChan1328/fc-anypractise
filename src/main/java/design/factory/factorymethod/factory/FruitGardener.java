package design.factory.factorymethod.factory;

import design.factory.factorymethod.fruit.Fruit;

public interface FruitGardener {
    /**
     * 工厂方法
     */
    public Fruit factory();
}