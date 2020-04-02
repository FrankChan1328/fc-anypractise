package thread.thread.join;

public class ThreadOrder {

    public static void main(String[] args) throws Exception {
        System.out.println("===== Main Start=====");
//        noOrderRun();
        inOrderRun();
        System.out.println("===== Main End=====");
    }
    
    public static void inOrderRun() throws Exception {
        Thread t1 = new Thread(() -> print(1));
        Thread t2 = new Thread(() -> print(2));
        Thread t3 = new Thread(() -> print(3));
        
        t1.start();
        t1.join();
        
        t2.start();
        t2.join();
        
        t3.start();
        t3.join();
    }
    
    /**
     * 线程无序执行
     */
    public static void noOrderRun(){
        Thread t1 = new Thread(() -> print(1));
        Thread t2 = new Thread(() -> print(2));
        Thread t3 = new Thread(() -> print(3));
        t1.start();
        t2.start();
        t3.start();
    }

    public static void print(int index) {
        for (int i = 0; i < 5; i++) {
            System.out.println("I am " + index + " !");
        }
    }

}
