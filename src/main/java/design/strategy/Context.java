package design.strategy;

import design.strategy.strategy.DiscountStrategy;

/**
 * context 持有一个strategy 的引用
 */
public class Context {
    private DiscountStrategy strategy;

    public Context(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public float getToReduce() {
        return strategy.calculateDiscount();
    }

}
