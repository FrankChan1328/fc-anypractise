package design.factory.factorymethod.factory;

import design.factory.factorymethod.fruit.Apple;
import design.factory.factorymethod.fruit.Fruit;

public class AppleGardener implements FruitGardener {
	public Fruit factory() {
		return new Apple();
	}
}
