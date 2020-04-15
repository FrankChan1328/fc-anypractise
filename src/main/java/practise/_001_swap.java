package practise;

/**
 * 元素顺序对调
 */
public class _001_swap {

	public static void main(String[] args) {
		int a[] = { 1, 2, 4, 8 };
		swap(a);
		System.out.println(a);
	}

	public static void swap(int a[]) {
		int len = a.length;
		for (int i = 0; i < len / 2; i++) {
			int tmp = a[i];
			a[i] = a[len - 1 - i];
			a[len - 1 - i] = tmp;
		}
	}
}
