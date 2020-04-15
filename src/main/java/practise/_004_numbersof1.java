package practise;

/**
 * 0 ~ n 之间出现1 的个数 
 * 思路： 
 * 第n 个数有几个1； 
 * 前n-1 个数有几个1；
 *
 */
public class _004_numbersof1 {

	public static void main(String[] args) {
		System.out.println(numOfOneFn(100));
	}

	public static int numOfOne(int a) { // 某个数有多少个1；
		String s = a + "";
		char[] a1 = s.toCharArray();
		int count = 0;
		for (int i = 0; i < a1.length; i++) {
			if (a1[i] == '1')
				count++;
		}
		return count;
	}

	public static int numOfOneFn(int n) { // 递归
		if (n == 1)
			return 1;
		else
			return (numOfOneFn(n - 1) + numOfOne(n));
	}
}
