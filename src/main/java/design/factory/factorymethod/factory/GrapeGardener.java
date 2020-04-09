package design.factory.factorymethod.factory;

import design.factory.factorymethod.fruit.Fruit;
import design.factory.factorymethod.fruit.Grape;

public class GrapeGardener implements FruitGardener {
	public Fruit factory() {
		return new Grape();
	}
}
