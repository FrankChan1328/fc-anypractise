package java8.groupingby;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.comparingInt;

public class GroupingByTest1 {
    public static final List<Dish> menu =
            asList( new Dish("pork", false, 800, Dish.Type.MEAT),
                    new Dish("beef", false, 700, Dish.Type.MEAT),
                    new Dish("chicken", false, 400, Dish.Type.MEAT),
                    new Dish("french fries", true, 530, Dish.Type.OTHER),
                    new Dish("rice", true, 350, Dish.Type.OTHER),
                    new Dish("season fruit", true, 120, Dish.Type.OTHER),
                    new Dish("pizza", true, 550, Dish.Type.OTHER),
                    new Dish("prawns", false, 400, Dish.Type.FISH),
                    new Dish("salmon", false, 450, Dish.Type.FISH));
    
    public static void main(String[] args) {
        calMax();
    }
    
    private int calculateTotalCalories() {
        return menu.stream().collect(summingInt(Dish::getCalories));
    }
    
    private static void calMax(){
        Map<Dish.Type, Optional<Dish>> mostCaloricByType =
                menu.stream()
                .collect(groupingBy(Dish::getType,
                maxBy(comparingInt(Dish::getCalories))));
        System.out.println(mostCaloricByType);
        
        
        Map<Dish.Type, Dish> mostCaloricByType2 = menu.stream().collect(
                groupingBy(Dish::getType, collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(mostCaloricByType2);
    }
}
