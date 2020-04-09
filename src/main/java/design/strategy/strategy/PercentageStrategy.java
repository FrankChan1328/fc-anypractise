package design.strategy.strategy;

/**
 * 百分比折扣
 */
public class PercentageStrategy extends DiscountStrategy {
    /**
     * 具体折扣比例
     */
    private float discountPercent;

    public PercentageStrategy(float price, int numbers, float discountPercent) {
        super(price, numbers);
        this.discountPercent = discountPercent;
    }

    @Override
    public float calculateDiscount() {
        return discountPercent * price * numbers;
    }

}