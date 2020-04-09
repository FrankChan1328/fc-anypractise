package design.factory.simple;

import design.factory.simple.factory.FruitGardener;
import design.factory.simple.fruit.Fruit;

public class Client {

	public static void main(String[] args) {
		try {
			Fruit fruit = FruitGardener.factory("grape");
			fruit.grow();
			fruit.plant();
			fruit.harvest();
		}
		catch(Exception e) {
			//
		}
	}

}
