package design.strategy.lambdastrategy.predicate;

import design.strategy.lambdastrategy.Apple;

public class AppleRedAndHeavyPredicate implements ApplePredicate {
	public boolean test(Apple apple) {
		return "red".equals(apple.getColor()) && apple.getWeight() > 150;
	}
}