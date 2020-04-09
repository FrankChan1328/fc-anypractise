package design.factory.abstractfactory.factory;

import design.factory.abstractfactory.product.fruit.Fruit;
import design.factory.abstractfactory.product.fruit.TropicalFruit;
import design.factory.abstractfactory.product.veggie.TropicalVeggie;
import design.factory.abstractfactory.product.veggie.Veggie;

public class TropicalGardener implements Gardener {
	/**
	 * 水果的工廠方法
	 */
	public Fruit createFruit(String name) {
		return new TropicalFruit(name);
	}

	/**
	 * 蔬菜的工廠方法
	 */
	public Veggie createVeggie(String name) {
		return new TropicalVeggie(name);
	}
}