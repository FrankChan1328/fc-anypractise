package collection.set.treeset;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 自定义一个Student类实现Comparable接口（该接口用于指定排序规则）,
 * Student类包含学号和姓名属性，使用TreeSet添加一组Student类的对象，然后循环输出学生信息！
 * <2> 分析
 * TreeSet 是一个有序集合，其中的元素将按照升序排列，缺省是按照自然排序进行排列。
 * TreeSet 中的元素要实现Comparable 接口，或者有个自定义的比较器。
 */
public class Student implements Comparable<Student> {
	private int id;
	private String name;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	// Student 类的字符串表达式，形如： 2 张三
	public String toString() {
		return (id + "\t" + name);
	}
	
	public int compareTo(Student arg) {
		if (id > arg.id)
			return 1;
		else if (id == arg.id)
			return 0;
		else
			return -1;
	}

	/*
	 * 以下为主方法，输出结果是： 3 John 5 Tom 7 Alice 9 David 可以看到不同于输入顺序，TreeSet 已经将其排序了。
	 */
	public static void main(String args[]) {
		TreeSet<Student> tset = new TreeSet<Student>();
		tset.add(new Student(5, "Tom"));
		tset.add(new Student(3, "John"));
		tset.add(new Student(9, "David"));
		tset.add(new Student(7, "Alice"));

		Iterator<Student> itor = tset.iterator();
		while (itor.hasNext()) {
			System.out.println(itor.next().toString());
		}
	}
}