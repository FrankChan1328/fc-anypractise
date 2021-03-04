package design.other.reduceif.factorymethod.cal;

public class Subtraction implements Calculator {
	@Override
	public int execute(int a, int b) {
		return a - b;
	}
}
