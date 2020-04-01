package thread.blockingqueue.consumer;

import thread.blockingqueue.Toast;
import thread.blockingqueue.ToastQueue;

public class Eater implements Runnable {
	private ToastQueue finishedQueue;
	private int counter = 0;

	public Eater(ToastQueue finished) {
		finishedQueue = finished;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until next piece of toast is available:
				Toast t = finishedQueue.take();
				// Verify that the toast is coming in order,
				// and that all pieces are getting jammed:
				if (t.getId() != counter++ || t.getStatus() != Toast.Status.JAMMED) {
					System.out.print(">>>> Error: " + t);
					System.exit(1);
				} else
					System.out.print("Chomp! " + t);
			}
		} catch (InterruptedException e) {
			System.out.print("Eater interrupted");
		}
		System.out.print("Eater off");
	}
}
