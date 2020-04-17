package thread.executor.cases.taskwithresult;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 必须使用ExecutorService.submit() 方法调用Callable
 * <p> submit() 方法会返回Future 对象，可以使用 isDone() 来查询Future 是否完成
 *
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }

        try {
            for (Future<String> fs : results) {
                System.out.println(fs.get());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        exec.shutdown();
    }
}
