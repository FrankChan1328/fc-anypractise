package thread.thread.order;

/**
 * 方法1：主线程join
 */
public class _01_Join {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = ThreadFactory.getT1();
        Thread t2 = ThreadFactory.getT2();
        Thread t3 = ThreadFactory.getT3();
        
        t1.start();
        t1.join();
        
        t2.start();
        t2.join();
        
        t3.start();
        t3.join();
    }
}
