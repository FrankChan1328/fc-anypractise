package design.strategy;

import design.strategy.strategy.DiscountStrategy;
import design.strategy.strategy.FlatRateStrategy;

public class Client {

    public static void main(String[] args) {
        float price = 100f;
        int nums = 20;

        DiscountStrategy strategy = new FlatRateStrategy(price, nums, 10f);
        
        Context context = new Context(strategy);
        float toReduce = context.getToReduce();

        System.out.println(toReduce);
    }
}
