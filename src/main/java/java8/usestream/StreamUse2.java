package java8.usestream;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class StreamUse2 {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        nums.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
        
//        int product = nums.stream().reduce(1, (a, b) -> a * b);
//        
//        int sum = nums.stream().reduce(0, (a, b) -> a + b);
//        
        int sum = 0;
        for (int x : nums) {
        sum += x;
        }
        
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
        .map(String::length).collect(toList());
        
        List<String[]> list = words.stream()
        .map(word -> word.split(""))
        .distinct()
        .collect(toList());
        
        List<String> uniqueCharacters =
                words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        
        System.out.println(uniqueCharacters);
        
        if(words.stream().anyMatch(v -> v.equals("In"))){
            System.out.println("in");
        }
        
    }
}
