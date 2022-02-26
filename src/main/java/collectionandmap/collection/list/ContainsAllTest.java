package collectionandmap.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ContainsAllTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("A");
		list.add("A");

		List<String> list2 = new ArrayList<>();
		list2.add("A");
		list2.add("B");
		list2.add("A");

		System.out.println(list2.containsAll(list));
	}

}
