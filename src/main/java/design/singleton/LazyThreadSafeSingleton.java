package design.singleton;

/**
 * 线程安全懒汉式单例
 * <p> 调用时才创建
 */
public class LazyThreadSafeSingleton {
    private static LazyThreadSafeSingleton ins;

    private LazyThreadSafeSingleton() {

    }

    /**
     * static 修饰static，锁的是调用这个方法的对象的类(Class) 而不是对象
     * <p> 等价于 public xxx method(){ synchronized(Foo.class){ } }
     */
    public synchronized static LazyThreadSafeSingleton getInstance() {
        if (null == ins) {
            ins = new LazyThreadSafeSingleton();
        }
        return ins;
    }

    /*
     * public synchronized static LazyThreadSafeSingleton getInstance() {
     *  synchronized (LazyThreadSafeSingleton.class) { 
     *      if (null == ins) { 
     *          ins = new LazyThreadSafeSingleton(); 
     *      } 
     *      return ins;
     *  } 
     * }
     */
}
