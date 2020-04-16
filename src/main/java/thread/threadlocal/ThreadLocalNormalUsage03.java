package thread.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1000个线程打印日期，用线程池来执行，出现线程安全问题,出现秒数相同的打印结果
 */
public class ThreadLocalNormalUsage03 {

	public static ExecutorService threadPool = Executors.newFixedThreadPool(10);
	// 只创建一次 SimpleDateFormat 对象，避免不必要的资源消耗
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 1000; i++) {
			int finalI = i;
			// 提交任务
			threadPool.submit(new Runnable() {
				@Override
				public void run() {
					String date = new ThreadLocalNormalUsage03().date(finalI);
					System.out.println(date);
				}
			});
		}
		threadPool.shutdown();
	}

	public String date(int seconds) {
		// 参数的单位是毫秒，从1970.1.1 00:00:00 GMT 开始计时
		Date date = new Date(1000 * seconds);
		return dateFormat.format(date);
	}
}
