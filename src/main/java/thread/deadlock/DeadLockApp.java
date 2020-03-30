package thread.deadlock;

public class DeadLockApp {
    public static void main(String[] args) {

        /*** 死锁演示线程初始化 */
        ResourceManager resourceManager = new ResourceManager();
        CustomizeThread customizedThread0 = new CustomizeThread(resourceManager, 1, 2);
        CustomizeThread customizedThread1 = new CustomizeThread(resourceManager, 2, 4);

        /*** 死锁演示线程启动 */
        customizedThread0.start();
        customizedThread1.start();
    }
}