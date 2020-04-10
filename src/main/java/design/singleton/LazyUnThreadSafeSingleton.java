package design.singleton;

/**
 * 线程安全懒汉式单例
 * <p>
 * 调用时才创建
 */
public class LazyUnThreadSafeSingleton {
    private static LazyUnThreadSafeSingleton ins;

    private LazyUnThreadSafeSingleton() {

    }

    public static LazyUnThreadSafeSingleton getInstance() {
        if (null == ins) {
            synchronized (LazyUnThreadSafeSingleton.class) {
                ins = new LazyUnThreadSafeSingleton();
            }
        }
        return ins;
    }
}
