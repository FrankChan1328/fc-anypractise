package design.other.reduceif.factorymethod;

import java.util.HashMap;
import java.util.Map;

import design.other.reduceif.factorymethod.cal.Addition;
import design.other.reduceif.factorymethod.cal.Calculator;
import design.other.reduceif.factorymethod.cal.Division;
import design.other.reduceif.factorymethod.cal.Multiplication;
import design.other.reduceif.factorymethod.cal.Subtraction;

public class CalculatorHolder {
	private static Map<String, Calculator> calculatorMap = new HashMap<>();

	static {
		calculatorMap.put("ADD", new Addition());
		calculatorMap.put("SUB", new Subtraction());
		calculatorMap.put("MUL", new Multiplication());
		calculatorMap.put("DIV", new Division());
	}

	public static Calculator getCalculator(String action) {
		return calculatorMap.get(action);
	}
}