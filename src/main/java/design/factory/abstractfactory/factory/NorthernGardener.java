package design.factory.abstractfactory.factory;

import design.factory.abstractfactory.product.fruit.Fruit;
import design.factory.abstractfactory.product.fruit.NorthernFruit;
import design.factory.abstractfactory.product.veggie.NorthernVeggie;
import design.factory.abstractfactory.product.veggie.Veggie;

public class NorthernGardener implements Gardener {
	/**
	 * 水果的工廠方法
	 */
	public Fruit createFruit(String name) {
		return new NorthernFruit(name);
	}

	/**
	 * 蔬菜的工廠方法
	 */
	public Veggie createVeggie(String name) {
		return new NorthernVeggie(name);
	}
}