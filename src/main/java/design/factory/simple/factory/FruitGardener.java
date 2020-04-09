package design.factory.simple.factory;

import design.factory.simple.fruit.Apple;
import design.factory.simple.fruit.Fruit;
import design.factory.simple.fruit.Grape;
import design.factory.simple.fruit.Strawberry;

public class FruitGardener {
	/**
	 * 静态工厂方法
	 */
	public static Fruit factory(String which) throws Exception {
		if (which.equals("apple")) {
			return new Apple();
		} else if (which.equals("strawberry")) {
			return new Strawberry();
		} else if (which.equals("grape")) {
			return new Grape();
		} else {
			throw new Exception();
		}
	}
}
