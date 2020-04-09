package design.strategy.strategy;

/**
 * 固定量值折扣，每个折扣几元
 */
public class FlatRateStrategy extends DiscountStrategy {
    /**
     * 具体折扣金额
     */
    private float discountAmount;

    public FlatRateStrategy(float price, int numbers, float discountAmount) {
        super(price, numbers);
        this.discountAmount = discountAmount;
    }

    @Override
    public float calculateDiscount() {
        return discountAmount * numbers;
    }
}