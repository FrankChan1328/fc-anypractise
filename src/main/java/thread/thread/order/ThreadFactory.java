package thread.thread.order;

public class ThreadFactory {
    private static final String THREAD_1 = "产品经理规划新需求";
    private static final String THREAD_2 = "开发人员开发新需求功能";
    private static final String THREAD_3 = "测试人员测试新功能";

    private static Thread genThread(String msg) {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 7; i++) {
                    System.out.println(msg);
                }
            }
        });
        return thread1;
    }

    /**
     * 产品经理线程
     */
    public static Thread getT1() {
        return genThread(THREAD_1);
    }

    /**
     * 开发人员线程
     */
    public static Thread getT2() {
        return genThread(THREAD_2);
    }

    /**
     * 测试人员线程
     */
    public static Thread getT3() {
        return genThread(THREAD_3);
    }
}
