package thread.lock.optimisticandpessimistic.cases1;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreeType {

	// value1：线程不安全
	private static int value1 = 0;

	// value2：使用乐观锁
	private static AtomicInteger value2 = new AtomicInteger(0);

	// value3：使用悲观锁
	private static int value3 = 0;

	private static synchronized void increaseValue3() {
		value3++;
	}

	public static void main(String[] args) throws Exception {
		// 开启1000个线程，并执行自增操作
		for (int i = 0; i < 1000; ++i) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// 线程不安全
					value1++;

					// 乐观锁
					value2.getAndIncrement();

					// 悲观锁
					increaseValue3();
				}
			}).start();
		}
		while (Thread.activeCount() > 1) // 保证前面的线程都执行完
			Thread.yield();

		System.out.println("线程不安全：" + value1);
		System.out.println("乐观锁(AtomicInteger)：" + value2);
		System.out.println("悲观锁(synchronized)：" + value3);
	}
}