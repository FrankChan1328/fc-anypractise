package thread.queue.blockingqueue.linkedblockingqueue.producerandconsumer.producer;

import thread.queue.blockingqueue.linkedblockingqueue.producerandconsumer.queue.Toast;
import thread.queue.blockingqueue.linkedblockingqueue.producerandconsumer.queue.ToastQueue;

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
				System.out.println(t);
				butteredQueue.put(t);
			}
		} catch (InterruptedException e) {
			System.out.println("Butterer interrupted");
		}
		System.out.println("Butterer off");
	}
}
