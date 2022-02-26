package java8.filtering;

import static java.util.stream.Collectors.toList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class IntersectionTest {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>(Arrays.asList("a","b","c"));
		List<String> list2 = new ArrayList<>(Arrays.asList("d","b","c","e"));
		
		List<String> intersections =  Optional.ofNullable(list1).orElse(
				new ArrayList<>())
				.stream()
				.filter(item -> Optional.ofNullable(list2).orElse(new ArrayList<>()).contains(item)).collect(toList());
		System.out.print(intersections);
	}

}
