package design.prototype.register;

import java.util.Vector;

/**
 * 原型管理器
 */
public class PrototypeManager {
    private Vector objects = new Vector();

    /**
     * 聚集管理方法：添加
     */
    public void add(Prototype object) {
        objects.add(object);
    }

    /**
     * 聚集管理方法：取
     */
    public Prototype get(int i) {
        return (Prototype) objects.get(i);
    }

    /**
     * 聚集管理方法：取得聚集大小
     */
    public int getSize() {
        return objects.size();
    }
}
