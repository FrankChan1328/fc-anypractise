package thread.executor.cases.pipedio;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * PipedReader 与普通IO 最重要的差异是，PipedReader 是可被中断的。
 * <p> 可认为是"生产者-消费者"问题的变体，管道是一个封装好的解决方案，基本上是一个阻塞队列。
 * <p> 现在通常都用BlockingQueue
 */
public class PipedIO {

    public static void main(String[] args) throws IOException, InterruptedException {
        // 两个任务使用同一管道进行通信
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);

        TimeUnit.SECONDS.sleep(4);

        exec.shutdown();
    }
}
