package design.strategy.lambdastrategy.predicate;

import design.strategy.lambdastrategy.Apple;

public class AppleWeightPredicate implements ApplePredicate {
	public boolean test(Apple apple) {
		return apple.getWeight() > 150;
	}
}
