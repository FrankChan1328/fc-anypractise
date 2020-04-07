package thread.lock.fairlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 非公平锁，锁获取的机会不是相同的，不保证锁的访问顺序
 */
public class MyUnfairLock extends Thread {
    private ReentrantLock lock = new ReentrantLock(false);

    public void fairLock() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "正在持有锁");
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了锁");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyUnfairLock myFairLock = new MyUnfairLock();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            myFairLock.fairLock();
        };
        
        Thread[] thread = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(runnable);
        }
        
        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }
    }
}