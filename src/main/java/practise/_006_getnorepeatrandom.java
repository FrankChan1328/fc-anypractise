package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 产生不重复的随机数
 */
public class _006_getnorepeatrandom {

	public static void main(String[] args) {
		nonRepeatRandom();
	}

	/**
	 * 先产生100 个数字，然后再shuffle
	 * http://stackoverflow.com/questions/16000196/java-generating-non-repeating-random-numbers
	 */
	public static void nonRepeatRandom() {
		Integer[] arr = new Integer[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

		Collections.shuffle(Arrays.asList(arr));
		System.out.println(Arrays.toString(arr));
	}

	public static Integer[] getRandoms(int size) {
		Integer[] intRandom = new Integer[size];
		List<Integer> mylist = new ArrayList<>(); // 生成数据集，用来保存随即生成数，并用于判断
		Random rd = new Random();

		while (mylist.size() < size) {
			int num = rd.nextInt(size);

			if (!mylist.contains(num)) {
				mylist.add(num); // 往集合里面添加数据。
			}
		}

		for (Integer i = 0; i < mylist.size(); i++) {
			intRandom[i] = (Integer) (mylist.get(i));
		}
		return intRandom;
	}
}
