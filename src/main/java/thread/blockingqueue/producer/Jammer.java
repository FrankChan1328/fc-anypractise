package thread.blockingqueue.producer;

import thread.blockingqueue.Toast;
import thread.blockingqueue.ToastQueue;

public class Jammer implements Runnable {
	private ToastQueue butteredQueue, finishedQueue;

	public Jammer(ToastQueue buttered, ToastQueue finished) {
		butteredQueue = buttered;
		finishedQueue = finished;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until next piece of toast is available:
				Toast t = butteredQueue.take();
				t.jam();
				System.out.print(t);
				finishedQueue.put(t);
			}
		} catch (InterruptedException e) {
			System.out.print("Jammer interrupted");
		}
		System.out.print("Jammer off");
	}
}