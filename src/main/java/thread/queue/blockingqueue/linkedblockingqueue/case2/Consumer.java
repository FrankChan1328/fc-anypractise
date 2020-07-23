package thread.queue.blockingqueue.linkedblockingqueue.case2;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<Food> queue;

    public Consumer(BlockingQueue<Food> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random rm = new Random();
        try {
            while (true) {
                int random = rm.nextInt(2000);
                Thread.sleep(random);
                Food fd = queue.take();
                System.out.println("取出:" + fd.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
