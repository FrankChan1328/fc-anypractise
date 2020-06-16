package design.strategy.lambdastrategy.predicate;

import design.strategy.lambdastrategy.Apple;

public class AppleColorPredicate implements ApplePredicate {
	public boolean test(Apple apple) {
		return "green".equals(apple.getColor());
	}
}
