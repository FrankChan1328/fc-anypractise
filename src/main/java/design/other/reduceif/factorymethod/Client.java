package design.other.reduceif.factorymethod;

public class Client {

	public static void main(String[] args) {
		CalculatorHolder.getCalculator("ADD").execute(1, 2);
		CalculatorHolder.getCalculator("MUL").execute(1, 2);
	}

}
