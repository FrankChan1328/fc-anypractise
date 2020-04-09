package design.factory.abstractfactory;

import design.factory.abstractfactory.factory.Gardener;
import design.factory.abstractfactory.factory.NorthernGardener;
import design.factory.abstractfactory.product.fruit.Fruit;
import design.factory.abstractfactory.product.veggie.Veggie;

public class Client {

	public static void main(String[] args) {
		Gardener gardener = new NorthernGardener();
		Fruit fruit = gardener.createFruit("north apple");
		Veggie veggie = gardener.createVeggie("north veggie");
	}
}
