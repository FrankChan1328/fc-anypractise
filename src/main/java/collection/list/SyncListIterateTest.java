package collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * synchronized 的遍历是不安全的
 */
public class SyncListIterateTest {

    public static void main(String[] args) {
        SyncListIterateTest test = new SyncListIterateTest();
        // synchronized 的不安全遍历
        // test.unsafeIterator();
        
        // synchronized 的安全遍历
        test.safeIterator();
    }

    /**
     * 安全遍历
     */
    public void unsafeIterator() {
        Manager engine = new Manager();
        // 开线程模拟不停的加数据
        new Thread(() -> multiRun(engine)).start();
        // 开线程模拟不停的 遍历并移除数据
        while (true) {
            iterate(engine);
        }
    }

    /**
     * 安全遍历
     */
    public void safeIterator() {
        Manager engine = new Manager();
        // 开线程模拟不停的加数据
        new Thread(() -> multiRun(engine)).start();
        // 开线程模拟不停的 遍历并移除数据
        while (true) {
            synchronized (engine.getManagers()) {
                iterate(engine);
            }
        }
    }

    private void iterate(Manager engine) {
        if (null != engine.getManagers() && engine.getManagers().size() > 0) {
            System.out.println("size:" + engine.getManagers().size());
            Iterator<String> iter = engine.getManagers().iterator();
            while (iter.hasNext()) {
                System.out.println(iter.next());
                iter.remove();
            }
        }
    }

    private void multiRun(Manager engine) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> engine.add(UUID.randomUUID().toString())).start();
        }
    }

    /**
     * 抽象manager ，维护volatile synchronizedList
     */
    public class Manager {
        private volatile List<String> managers;

        public Manager() {
            managers = Collections.synchronizedList(new ArrayList<>());

        }

        public void add(String s) {
            if (null != managers) {
                managers.add(s);
            }
        }

        public List<String> getManagers() {
            return managers;
        }
    }
}
