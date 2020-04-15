package practise;

/**
 * 斐波那契数列
 */
public class _003_fibonaci {

	public static void main(String[] args) {
		System.out.println(fibonaci(3));
	}

	/**
	 * 斐波那契数列，f(n) = f(n -1) + f(n -2)
	 */
	public static int fibonaci(int m) {
		if (m == 0 || m == 1)
			return m;
		else
			return (fibonaci(m - 1) + fibonaci(m - 2));
	}

}
