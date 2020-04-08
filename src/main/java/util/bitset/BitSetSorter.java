package util.bitset;

import java.util.Arrays;
import java.util.BitSet;

/**
 * 1. 位图排序
 * <p>在一些场景下，需要排序的数据不存在重复，分布较为均匀，那么可以使用位图进行排序。
 * 由于不需要进行比较操作，算法复杂度可以突破 常见的基于比较操作的排序算法的复杂度上限 O(n ∗ log(n)) , 达到 O(n) 。
 * <p>排序流程如下:
 * <li>遍历输入数组，在位图中设置对应位.</li>
 * <li>遍历位图， 将位图中设置为1的位下标，依次写回输入数组.</li>
 * <p>
 * 2.两个前置条件
 * 关于上面提到的两个前置条件：
 * 如果输入中存在重复元素，则排序后的结果中会丢失重复的元素，结果错误。
 * 如果输入元素分布不太均匀，比如[1, 100, 10000], 会导致位图遍历的开销过大，进而会使整个排序性能低于基与比较的排序方法。
 *
 */
public class BitSetSorter {
	public static void sort(int arr[]) {
		BitSet bs = new BitSet();

		for (int v : arr) {
			bs.set(v);
		}

		int arrIdx = 0;
		for (int i = bs.nextSetBit(0); i >= 0; i = bs.nextSetBit(i + 1)) {
			arr[arrIdx++] = i;
		}
	}

	public static void main(String[] args) {
		int arr[] = { 9, 2, 4, 5, 7, 3, 1 };
		System.out.println("排序前数组: " + Arrays.toString(arr));
		BitSetSorter.sort(arr);
		System.out.println("排序后数组: " + Arrays.toString(arr));
	}
}
