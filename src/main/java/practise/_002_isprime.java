package practise;

/**
 * 判断是否素数
 */
public class _002_isprime {

	public static void main(String[] args) {
		System.out.println(isPrime(1));
		System.out.println(isPrime(2));
		System.out.println(isPrime(4));
	}

	private static boolean isPrime(int m) {
		if (m == 1)
			return true;

		int k = (int) Math.sqrt(m);
		for (int i = 2; i <= k; i++) {
			if (m % i == 0) {
				return false;
			}
		}
		return true;
	}
}
