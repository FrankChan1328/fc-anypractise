package thread.blockingqueue.producer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import thread.blockingqueue.Toast;
import thread.blockingqueue.ToastQueue;

public class Toaster implements Runnable {
	private ToastQueue toastQueue;
	private int count = 0;
	private Random rand = new Random(47);

	public Toaster(ToastQueue tq) {
		toastQueue = tq;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {

				TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
				// 制作吐司
				Toast t = new Toast(count++);
				System.out.print(t);
				// 插入队列中
				toastQueue.put(t);
			}
		} catch (InterruptedException e) {
			System.out.print("Toaster interrupted");
		}
		System.out.print("Toaster off");
	}
}