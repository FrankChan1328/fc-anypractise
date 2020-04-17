package thread.executor.cases.taskwithresult;

import java.util.concurrent.Callable;

/**
 * Runnable 不返回任何值，Callable 是具有类型参数的泛型，从call 中返回值
 */
public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of task :" + id;
    }
}
