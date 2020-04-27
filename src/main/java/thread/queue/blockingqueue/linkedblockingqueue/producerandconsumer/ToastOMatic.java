package thread.queue.blockingqueue.linkedblockingqueue.producerandconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import thread.queue.blockingqueue.linkedblockingqueue.producerandconsumer.consumer.Eater;
import thread.queue.blockingqueue.linkedblockingqueue.producerandconsumer.producer.Butterer;
import thread.queue.blockingqueue.linkedblockingqueue.producerandconsumer.producer.Jammer;
import thread.queue.blockingqueue.linkedblockingqueue.producerandconsumer.producer.Toaster;
import thread.queue.blockingqueue.linkedblockingqueue.producerandconsumer.queue.ToastQueue;


public class ToastOMatic {
	public static void main(String[] args) throws Exception {
		ToastQueue dryQueue = new ToastQueue(), butteredQueue = new ToastQueue(), finishedQueue = new ToastQueue();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Toaster(dryQueue));
		exec.execute(new Butterer(dryQueue, butteredQueue));
		exec.execute(new Jammer(butteredQueue, finishedQueue));
		exec.execute(new Eater(finishedQueue));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}
}