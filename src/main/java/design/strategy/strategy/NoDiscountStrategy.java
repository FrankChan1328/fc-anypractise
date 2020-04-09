package design.strategy.strategy;

/**
 * 没有折扣
 */
public class NoDiscountStrategy extends DiscountStrategy {
    public NoDiscountStrategy(float price, int numbers) {
        super(price, numbers);
    }

    @Override
    public float calculateDiscount() {
        return 0;
    }
}