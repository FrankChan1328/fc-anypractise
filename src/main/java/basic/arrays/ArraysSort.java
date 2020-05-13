package basic.arrays;

import java.util.Arrays;

public class ArraysSort {

	public static void main(String[] args) {
		String[] strings = { "q", "a", "c" };
		Arrays.sort(strings);
		for (String val : strings) {
			System.out.print(val + " ");
		}
		
		System.out.println();
		
		int[] ints = { 50, 1, 4, 8, 3 };
		Arrays.sort(ints);
		for (int i = 0; i < ints.length; i++) {
			System.out.print(ints[i] + " ");
		}
	}

}
