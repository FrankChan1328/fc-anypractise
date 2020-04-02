package thread.thread.order;

public class _00_orginal {

    public static void main(String[] args) {
        Thread t1 = ThreadFactory.getT1();
        Thread t2 = ThreadFactory.getT2();
        Thread t3 = ThreadFactory.getT3();
        
        t1.start();
        t2.start();
        t3.start();
    }

}
