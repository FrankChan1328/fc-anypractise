package thread.deadlock;

public class CustomizeThread extends Thread {
    // 资源管理类的私有引用，通过此引用可以通过其相关接口对资源进行读写
    private ResourceManager resourceManger;

    // 将要写入资源的数据
    private int a, b;

    /**
     * 创建一个新的实例 CustomizeThread.
     */
    public CustomizeThread(ResourceManager resourceManger, int a, int b) {
        this.resourceManger = resourceManger;
        this.a = a;
        this.b = b;
    }

    /*** 重写 java.lang.Thread 的 run 方法 */
    public void run() {
        /**
         * 为了演示死锁的出现，这里对资源进行反复读写 实际业务中可能只读写一次
         */
        while (true) {
            this.resourceManger.read();
            this.resourceManger.write(this.a, this.b);
        }
    }
}