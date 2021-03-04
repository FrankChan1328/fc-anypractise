package design.other.reduceif.strategy;

import design.other.reduceif.strategy.cal.Calculator;

public class CalculatorHolder {

	private Calculator calculator;

	public CalculatorHolder(Calculator calculator) {
		this.calculator = calculator;
	}

	public int execute(int a, int b) {
		return calculator.execute(a, b);
	}
}
