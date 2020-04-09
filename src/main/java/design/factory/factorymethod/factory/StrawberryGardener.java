package design.factory.factorymethod.factory;

import design.factory.factorymethod.fruit.Fruit;
import design.factory.factorymethod.fruit.Strawberry;

public class StrawberryGardener implements FruitGardener{
    public Fruit factory(){
        return new Strawberry();
    }
}
