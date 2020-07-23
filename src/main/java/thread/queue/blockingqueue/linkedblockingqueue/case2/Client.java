package thread.queue.blockingqueue.linkedblockingqueue.case2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 一个简单的生产者消费者模型
 * <p>同一时间只有一个生产者生产
 * <p>同一时间只有一个消费者消费
 * <p>共享空间为空的时候消费者不能消费
 * <p>共享空间为满的时候生产者不能生产
 */
public class Client {
    public static void main(String[] args) {
        BlockingQueue<Food> foods = new LinkedBlockingQueue<Food>(20);

        Thread produce = new Thread(new Producer(foods));
        Thread consume = new Thread(new Consumer(foods));

        produce.start();
        consume.start();
    }
}
