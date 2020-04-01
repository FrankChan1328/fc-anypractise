package thread.threadlocal;

import java.util.Random;

public class ThreadLocalDemo implements Runnable {
	// 创建线程局部变量studentLocal，在后面你会发现用来保存Student对象
	private final static ThreadLocal<Student> studentLocal = new ThreadLocal<>();

	public static void main(String[] agrs) {
		ThreadLocalDemo td = new ThreadLocalDemo();
		Thread t1 = new Thread(td, "a");
		Thread t2 = new Thread(td, "b");
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println(currentThreadName + " is running!");
		// 获取本地线程变量并强制转换为Student类型
		Student student = (Student) studentLocal.get();
		// 线程首次执行此方法的时候，studentLocal.get()肯定为null
		if (student == null) {
			// 创建一个Student对象，并保存到本地线程变量studentLocal中
			student = new Student();
			studentLocal.set(student);
		}
		Random random = new Random();
		student.setAge(random.nextInt(100));
		System.out.println("thread " + currentThreadName + " first read age is:" + student.getAge());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		System.out.println("thread " + currentThreadName + " second read age is:" + student.getAge());
	}
}