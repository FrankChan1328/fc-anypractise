package design.factory.abstractfactory.product.fruit;

/**
 * 熱帶水果
 */
public class TropicalFruit implements Fruit {
	private String name;

	public TropicalFruit(String name) {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}