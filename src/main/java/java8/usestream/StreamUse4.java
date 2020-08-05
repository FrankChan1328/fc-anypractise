package java8.usestream;

import static java.util.stream.Collectors.reducing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamUse4 {

    public static void main(String[] args) {
        List<Dish> menu = new ArrayList<>();
        menu.add(new Dish("pork", false, 800, Dish.Type.MEAT));
        Optional<Dish> oDish = menu.stream()
                .collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        Dish max = oDish.orElse(null);
        System.out.println(max);
        Dish max2 = menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2))
                .orElse(null);
        System.out.println(max);
        System.out.println(max2);
    }

}
