package thread.volatiled;

/**
 * 输出结果：非10000，可能是9880/9882/9999
 * 结论：volatile 虽然能保证可见性；但自增操作不是原子性的，即使volatile 修饰也不行；
 *
 */
public class VolatileAtmoicTest {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final VolatileAtmoicTest test = new VolatileAtmoicTest();
        
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++)
                        test.increase();
                };
            }.start();
        }

        while (Thread.activeCount() > 1) // 保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
    }
}
