package java8.filtering;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamUse1 {

    public static void main(String[] args) {
//        List<Dish> dishes = null;
//        getLowCaloricDishesNamesInJava8(dishes);
        
        streamOnece();
        List<Dish> menu = null;
        
        List<String> names =
                menu.stream()
                .filter(d -> {
                System.out.println("filtering" + d.getName());
                return d.getCalories() > 300;
                })
                .map(d -> {
                System.out.println("mapping" + d.getName());
                return d.getName();
                })
                .limit(3)
                .collect(toList());
                System.out.println(names);
                
//                List<Dish> dishes = menu.stream()
//                        .filter(d -> d.getCalories() > 300)
//                        .limit(3)
//                        .collect(toList());
                
                List<Dish> dishes = menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .skip(2)
                        .collect(toList());
                
                List<String> dishNames = menu.stream()
                        .map(Dish::getName)
                        .collect(toList());
                
                List<Integer> dishNameLengths = menu.stream()
                        .map(Dish::getName)
                        .map(String::length)
                        .collect(toList());
                
                if(menu.stream().anyMatch(Dish::isVegetarian)){
                    System.out.println("The menu is (somewhat) vegetarian friendly!!");
                    }
                
                
                
                boolean isHealthy = menu.stream()
                        .noneMatch(d -> d.getCalories() >= 1000);
                
                Optional<Dish> dish =
                        menu.stream()
                        .filter(Dish::isVegetarian)
                        .findAny();
                
                menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d -> System.out.println(d.getName()));
    }
    
    public static void streamOnece(){
        List<String> list = Arrays.asList("a","b","c");
        Stream<String> s = list.stream();
        s.forEach(System.out::println);
        Stream<String> s2 = list.stream();
        s2.forEach(System.out::println);
    }
    
    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes){
        return dishes.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }
    
    public void getThreeHighCaloris(List<Dish> menu) {
        List<String> threeHighCaloricDishNames = 
                menu.stream()
                    .filter(d -> d.getCalories() > 300)
                    .map(Dish::getName)
                    .limit(3)
                    .collect(toList());
        System.out.println(threeHighCaloricDishNames);
    }

    public static enum Type { MEAT, FISH, OTHER }

    
    private class Dish {

        private final String name;
        private final boolean vegetarian;
        private final int calories;
        private final Type type;

        public Dish(String name, boolean vegetarian, int calories, Type type) {
            this.name = name;
            this.vegetarian = vegetarian;
            this.calories = calories;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public boolean isVegetarian() {
            return vegetarian;
        }

        public int getCalories() {
            return calories;
        }

        public Type getType() {
            return type;
        }

        @Override
        public String toString() {
            return name;
        }
    }

}
