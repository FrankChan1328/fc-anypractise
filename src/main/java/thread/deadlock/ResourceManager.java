package thread.deadlock;

/**
 * 资源管理类：资源数据操作的接
 */
public class ResourceManager {
    /*** 管理的两个资源 */
    private Resource resourceA = new Resource();
    private Resource resourceB = new Resource();

    /*** 创建一个新的实例 ResourceManager. */
    public ResourceManager() {
        this.resourceA.setValue(0);
        this.resourceB.setValue(0);
    }

    /**
     * 资源的读取
     */
    public int read() {
        System.out.println(Thread.currentThread().getName()+" 准备 read...");
        synchronized (this.resourceA) {
            System.out.println(Thread.currentThread().getName() + " 线程拿到了资源A 的对象锁，尝试拿B 的对象锁...");
            synchronized (resourceB) {
                System.out.println(Thread.currentThread().getName() + "线程拿到了资源B 的对象锁");
                System.out.println(Thread.currentThread().getName()+" read完成");
                return this.resourceA.getValue() + this.resourceB.getValue();
            }
        }
    }

    /**
     * 资源的改写
     */
    public void write(int a, int b) {
        System.out.println(Thread.currentThread().getName()+" 准备 write...");
        synchronized (this.resourceB) {
            System.out.println(Thread.currentThread().getName() + " 线程拿到了资源B 的对象锁，尝试拿A的对象锁...");
            synchronized (this.resourceA) {
                System.out.println(Thread.currentThread().getName() + "线程拿到了资源A的对象锁");
                this.resourceA.setValue(a);
                this.resourceB.setValue(b);
            }
        }
        System.out.println(Thread.currentThread().getName()+" write完成");
    }
}
