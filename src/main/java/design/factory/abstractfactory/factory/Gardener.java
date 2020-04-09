package design.factory.abstractfactory.factory;

import design.factory.abstractfactory.product.fruit.Fruit;
import design.factory.abstractfactory.product.veggie.Veggie;

/**
 * 也可以是標識接口，沒有任何方法
 */
public interface Gardener {
	public Fruit createFruit(String name);

	public Veggie createVeggie(String name);
}