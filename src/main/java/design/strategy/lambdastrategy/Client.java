package design.strategy.lambdastrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import design.strategy.lambdastrategy.predicate.ApplePredicate;
import design.strategy.lambdastrategy.predicate.AppleRedAndHeavyPredicate;

public class Client {

	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));

		List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
		System.out.println(redAndHeavyApples);

		List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
			public boolean test(Apple a) {
				return a.getColor().equals("red");
			}
		});
		System.out.println(redApples2);
	}

	public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
}
