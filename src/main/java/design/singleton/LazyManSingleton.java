package design.singleton;

/**
 * 懒汉式单例
 * <p> 调用时才创建
 */
public class LazyManSingleton {
    private static LazyManSingleton ins;

    private LazyManSingleton() {

    }

    public static LazyManSingleton getInstance() {
        if (null == ins) {
            ins = new LazyManSingleton();
        }
        return ins;
    }
}
