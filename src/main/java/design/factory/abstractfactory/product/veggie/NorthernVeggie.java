package design.factory.abstractfactory.product.veggie;

/**
 * 北方的蔬菜
 */
public class NorthernVeggie implements Veggie {
	private String name;

	public NorthernVeggie(String name) {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}