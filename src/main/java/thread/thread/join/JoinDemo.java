package thread.thread.join;

public class JoinDemo {
    public static void main(String[] args) throws Exception {
        useJoin();
        System.out.println("==================");
        noJoin();
    }
    
    /**
     * 线程t 开始后，接着加入 t.join ，则阻塞主线程直到 t 线程执行完毕
     */
    public static void useJoin() throws Exception {
        System.out.println("start");

        Thread t = new Thread(() -> print());
        sleep();
        // 注意，先start 再join
        t.start();
        t.join();
        System.out.println("end");
    }
    
    /**
     * end 打印可能出现在任何地方
     * @throws Exception
     */
    public static void noJoin() throws Exception {
        System.out.println("start");

        Thread t = new Thread(() -> print());
        t.start();
        sleep();
        System.out.println("end");
    }

    public static void print() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            sleep();
        }
    }

    public static void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
