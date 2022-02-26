package design.other.reduceif.strategy;

import design.other.reduceif.strategy.cal.Addition;
import design.other.reduceif.strategy.cal.Subtraction;

public class Client {
	public static void main(String[] args) {
		CalculatorHolder ch = new CalculatorHolder(new Addition());
		ch.execute(1, 2);

		ch = new CalculatorHolder(new Subtraction());
		ch.execute(1, 2);
	}
}
