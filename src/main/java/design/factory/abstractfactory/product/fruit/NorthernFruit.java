package design.factory.abstractfactory.product.fruit;

/**
 * 北方水果
 */
public class NorthernFruit implements Fruit {
	private String name;

	public NorthernFruit(String name) {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
