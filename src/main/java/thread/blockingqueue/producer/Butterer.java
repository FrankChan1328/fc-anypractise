package thread.blockingqueue.producer;

import thread.blockingqueue.Toast;
import thread.blockingqueue.ToastQueue;

public class Butterer implements Runnable {
	private ToastQueue dryQueue, butteredQueue;

	public Butterer(ToastQueue dry, ToastQueue buttered) {
		dryQueue = dry;
		butteredQueue = buttered;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// 阻塞直到下一片toast是available:
				Toast t = dryQueue.take();
				t.butter();
				System.out.print(t);
				butteredQueue.put(t);
			}
		} catch (InterruptedException e) {
			System.out.print("Butterer interrupted");
		}
		System.out.print("Butterer off");
	}
}
