package thread.queue.blockingqueue.linkedblockingqueue.case2;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue<Food> queue;

    public Producer(BlockingQueue<Food> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random rm = new Random();
        try {
            int i = 0;
            while (true) {
//                int random = rm.nextInt(2000);
//                Thread.sleep(random);
                  
                Food fd = new Food("食物" + i);
                System.out.println("生产完食物:"+i);
                queue.put(fd);
                System.out.println("加入队列中:"+i);
                
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
