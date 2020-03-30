package thread.deadlock;

/**
 * 表示竞争的资源
 */
public class Resource {

    private int value;// 资源的属性

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}