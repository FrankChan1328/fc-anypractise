package design.strategy.strategy;

public abstract class DiscountStrategy {

    protected float price;

    protected int numbers;

    public DiscountStrategy(float price, int numbers) {
        this.price = price;
        this.numbers = numbers;
    }

    /**
     * 策略方法
     * 
     */
    public abstract float calculateDiscount();

}