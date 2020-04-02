package thread.thread.aqs.semaphore;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore可以用来做流量分流，特别是对公共资源有限的场景，比如数据库连接。
 * <p>假设有这个的需求，读取几万个文件的数据到数据库中，由于文件读取是IO密集型任务，可以启动几十个线程并发读取，但是数据库连接数只有10个，
 * 这时就必须控制最多只有10个线程能够拿到数据库连接进行操作。</p>
 * <p>这个时候，就可以使用Semaphore做流量控制。
 *
 */
public class SemaphoreTest {
    private static final int COUNT = 40;
    private static Executor executor = Executors.newFixedThreadPool(COUNT);
    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < COUNT; i++) {
            executor.execute(new Task(i));
        }
    }

    static class Task implements Runnable {
        private int index;
        
        public Task(int index){
            this.index = index;
        }
        
        @Override
        public void run() {
            try {
                Thread.sleep(500);
                System.out.println("线程:"+index+" 读取文件执行完成，尝试获取信号量......");
                // 读取文件操作
                semaphore.acquire();
                System.out.println("线程:"+index+" 成功获取信号量.");
                Thread.sleep(500);
                // 存数据过程
                semaphore.release();
                System.out.println("线程:"+index+" 释放信号量.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }
}
