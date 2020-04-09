package design.factory.simple.fruit;

public class Apple implements Fruit{
	/**
	 * 苹果树树龄
	 */
	private int treeAge;

	@Override
	public void grow() {
		System.out.println("Apple is growing...");
	}

	@Override
	public void harvest() {
		System.out.println("Apple has been harvested.");
	}

	@Override
	public void plant() {
		System.out.println("Apple has been planted.");
	}

	public int getTreeAge() {
		return treeAge;
	}

	public void setTreeAge(int treeAge) {
		this.treeAge = treeAge;
	}
}
