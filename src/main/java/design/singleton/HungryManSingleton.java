package design.singleton;

/**
 * 饿汉式单例 
 * <p>在调用前实例已经创建好
 */
public class HungryManSingleton {
    private static HungryManSingleton ins = new HungryManSingleton();

    private HungryManSingleton() {

    }

    public static HungryManSingleton getInstance() {
        return ins;
    }
}
