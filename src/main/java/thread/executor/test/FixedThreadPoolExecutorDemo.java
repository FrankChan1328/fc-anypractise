package thread.executor.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FixedThreadPoolExecutorDemo {

    private ExecutorService executor;
    
    private static FixedThreadPoolExecutorDemo instance = new FixedThreadPoolExecutorDemo();
    
    private FixedThreadPoolExecutorDemo() {
        executor = Executors.newFixedThreadPool(80);
    }
    
    /**
     * 添加任务。
     * @param task 任务
     */
    public static void addTask(Runnable task) {
        instance.executor.execute(task);
    }
    
    /**
     * 添加一个返回值的任务用于执行，返回一个表示任务的未决结果的 Future。
     * @param task 任务
     * @return 表示任务等待完成的 Future。
     */
    public static <T> Future<T> addTask(Callable<T> task) {
        return instance.executor.submit(task);
    }

    /**
     * 添加多个返回值的任务用于执行，返回多个表示任务的未决结果的 Future。
     * @param tasks
     * @param <T>
     * @return
     * @throws InterruptedException
     */
    public static <T> List<Future<T>> addTask(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        if (isEmpty(tasks)){
            return null;
        }

        List<Future<T>> futures = new ArrayList<>();
        for (Callable<T> task : tasks) {
            futures.add(instance.executor.submit(task));
        }

        return futures;
    }
    
    /**
     * 添加给定的任务，当所有任务完成时，返回保持任务状态和结果的 Future 列表。
     * @param tasks 任务列表
     * @return 表示任务的 Future 列表，列表顺序与给定任务列表的迭代器所生成的顺序相同，每个任务都已完成。
     * @throws InterruptedException 如果等待时发生中断，在这种情况下取消尚未完成的任务
     */
    public static <T> List<Future<T>> invokeTask(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        if(isNotEmpty(tasks)) {
            return instance.executor.invokeAll(tasks);
        }
        return null;
    }
    
    /**
     * 添加给定的任务，当所有任务完成或超时期满时（无论哪个首先发生），返回保持任务状态和结果的 Future 列表。
     * @param tasks 任务列表
     * @param timeout 最长等待时间（单位：秒）
     * @return 表示任务的 Future 列表，列表顺序与给定任务列表的迭代器所生成的顺序相同。如果操作未超时，则已完成所有任务。如果确实超时了，则某些任务尚未完成。
     * @throws InterruptedException 如果等待时发生中断，在这种情况下取消尚未完成的任务
     */
    public static <T> List<Future<T>> invokeTask(Collection<? extends Callable<T>> tasks, int timeout) throws InterruptedException {
        if(isNotEmpty(tasks)) {
            return instance.executor.invokeAll(tasks, timeout, TimeUnit.SECONDS);
        }
        return null;
    }
    
	public static <T> boolean isNotEmpty(Collection<? extends Callable<T>> tasks) {
		return null != tasks && tasks.size() > 0;
	}
	
	public static <T> boolean isEmpty(Collection<? extends Callable<T>> tasks) {
		return null == tasks || tasks.size() == 0;
	}
}
