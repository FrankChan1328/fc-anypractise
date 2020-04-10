package design.singleton;

/**
 * 双检查锁机制
 * 针对某些重要的代码进行单独的同步，而不是全部进行同步，能较大的提高执行效率
 */
public class DoubleCheckSingleton {
    private volatile static DoubleCheckSingleton ins;

    private DoubleCheckSingleton() {

    }

    public synchronized static DoubleCheckSingleton getInstance() {
        if (null == ins) {
            synchronized (DoubleCheckSingleton.class) {
                ins = new DoubleCheckSingleton();
            }
        }
        return ins;
    }
}
