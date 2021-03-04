package design.other.reduceif.strategy.cal;

public class Addition implements Calculator {
	@Override
	public int execute(int a, int b) {
		return a + b;
	}
}
