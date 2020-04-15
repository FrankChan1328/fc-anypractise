package practise;

import java.util.Random;

/**
 * 有一千万个随机数，随机范围在1到1亿之间。要求写出一种算法，将1到1亿之间没有在随机数中的数求出来。 
 * 说明：
 * * 求反交集
 */
public class _005_randomcheck {

	public static void main(String[] args) {
		radomCheck();
	}

	public static void radomCheck() {
		int[] randomNums = new int[10000000];
		Random random = new Random();
		for (int i = 0, length = randomNums.length; i < length; i++) {
			randomNums[i] = random.nextInt(100000000);
		}

		boolean[] bitArray = new boolean[10000000];
		for (int i = 0, length = randomNums.length; i < length; i++) {
			bitArray[randomNums[i]] = true;
		}

		for (int i = 0, length = bitArray.length; i < length; i++) {
			if (bitArray[i]) {
				continue;
			}
			System.out.println(i);
		}
	}
}
