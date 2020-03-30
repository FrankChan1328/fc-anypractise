package thread.deadlock2;

public class DeadLock {
    public static void main(String[] args) {

        new Thread(A::method, "Thread A").start();

        new Thread(B::method, "Thread B").start();
    }

    static class A {
        public synchronized static void method() {
            System.out.println("method from A");
            try {
                Thread.sleep(3000);// 为了让另外一个线程有机会拿到锁
                B.method();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class B {
        public synchronized static void method() {
            System.out.println("method from B");
            try {
                Thread.sleep(3000);
                A.method();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
