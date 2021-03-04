package basic.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(2, 5, 1));
		list.remove(2);
		System.out.println(list);
	}

}
