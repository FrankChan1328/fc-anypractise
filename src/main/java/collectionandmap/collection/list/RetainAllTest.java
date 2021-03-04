package collectionandmap.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * retainAll: 取交集
 * 对于操作 list1.retainAll(list2)
 * 如果list1 的内容没有改变，则返回false；
 * 如果list1 的内容发生改变，则返回true
 */
public class RetainAllTest {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		
		List<String> list2 = new ArrayList<>();
		list2.add("a");
		list2.add("b");
		
		boolean flag = list1.retainAll(list2);
		
		System.out.println(flag);
		System.out.println(list1);
	}
}
