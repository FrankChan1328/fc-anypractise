package design.factory.factorymethod;

import design.factory.factorymethod.factory.AppleGardener;
import design.factory.factorymethod.factory.FruitGardener;
import design.factory.factorymethod.factory.GrapeGardener;
import design.factory.factorymethod.fruit.Fruit;

public class Client {
	public static void main(String[] args) {
		FruitGardener creator1 = new AppleGardener();
		Fruit prod1 = creator1.factory();
		prod1.plant();
		prod1.grow();
		prod1.harvest();

		FruitGardener creator2 = new GrapeGardener();
		Fruit prod2 = creator2.factory();
		prod2.plant();
		prod2.grow();
		prod2.harvest();
	}
}