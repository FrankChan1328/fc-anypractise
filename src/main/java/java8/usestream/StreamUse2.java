package java8.usestream;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class StreamUse2 {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        nums.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
        
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
        .map(String::length).collect(toList());
    }
}
