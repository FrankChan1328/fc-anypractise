package thread.executor.sourcecode;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.Collection;

public interface ExecutorService extends Executor {

    /**
     * 平滑地关闭线程池，已经提交到线程池中的任务会继续执行完。
     */
    void shutdown();

    /**
     * 立即关闭线程池，返回还没有开始执行的任务列表。
     * 会尝试中断正在执行的任务（每个线程调用 interruput方法），但这个行为不一定会成功。
     */
    List<Runnable> shutdownNow();

    /**
     * 判断线程池是否已经关闭
     */
    boolean isShutdown();

    /**
     * 判断线程池的任务是否已经执行完毕。
     * 注意此方法调用之前需要先调用shutdown()方法或者shutdownNow()方法，否则总是会返回false
     */
    boolean isTerminated();

    /**
     * 判断线程池的任务是否都执行完。
     * 如果没有任务没有执行完毕则阻塞，直至任务完成或者达到了指定的timeout时间就会返回
     */
    boolean awaitTermination(long timeout, TimeUnit unit)
        throws InterruptedException;

    /**
     * 提交带有一个返回值的任务到线程池中去执行（回调），返回的 Future 表示任务的待定结果。
     * 当任务成功完成后，通过 Future 实例的 get() 方法可以获取该任务的结果。
     * Future 的 get() 方法是会阻塞的。
     */
    <T> Future<T> submit(Callable<T> task);

    /**
     *提交一个Runnable的任务，当任务完成后，可以通过Future.get()获取的是提交时传递的参数T result
     * 
     */
    <T> Future<T> submit(Runnable task, T result);

    /**
     * 提交一个Runnable的人无语，它的Future.get()得不到任何内容，它返回值总是Null。
     * 为什么有这个方法？为什么不直接设计成void submit(Runnable task)这种方式？
     * 这是因为Future除了get这种获取任务信息外，还可以控制任务，
     具体体现在 Future的这个方法上：boolean cancel(boolean mayInterruptIfRunning)
     这个方法能够去取消提交的Rannable任务。
     */
    Future<?> submit(Runnable task);

    /**
     * 执行一组给定的Callable任务，返回对应的Future列表。列表中每一个Future都将持有该任务的结果和状态。
     * 当所有任务执行完毕后，方法返回，此时并且每一个Future的isDone()方法都是true。
     * 完成的任务可能是正常结束，也可以是异常结束
     * 如果当任务执行过程中，tasks集合被修改了，那么方法的返回结果将是不确定的，
       即不能确定执行的是修改前的任务，还是修改后的任务
     */
    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
        throws InterruptedException;

    /**
     * 执行一组给定的Callable任务，返回对应的Future列表。列表中每一个Future都将持有该任务的结果和状态。
     * 当所有任务执行完毕后或者超时后，方法将返回，此时并且每一个Future的isDone()方法都是true。
     * 一旦方法返回，未执行完成的任务被取消，而完成的任务可能正常结束或者异常结束， 
     * 完成的任务可以是正常结束，也可以是异常结束
     * 如果当任务执行过程中，tasks集合被修改了，那么方法的返回结果将是不确定的
     */
    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,
                                  long timeout, TimeUnit unit)
        throws InterruptedException;

    /**
     * 执行一组给定的Callable任务，当成功执行完（没抛异常）一个任务后此方法便返回，返回的是该任务的结果
     * 一旦此正常返回或者异常结束，未执行的任务都会被取消。 
     * 如果当任务执行过程中，tasks集合被修改了，那么方法的返回结果将是不确定的
     */
    <T> T invokeAny(Collection<? extends Callable<T>> tasks)
        throws InterruptedException, ExecutionException;

    /**
     * 执行一组给定的Callable任务，当在timeout（超时）之前成功执行完（没抛异常）一个任务后此方法便返回，返回的是该任务的结果
     * 一旦此正常返回或者异常结束，未执行的任务都会被取消。 
     * 如果当任务执行过程中，tasks集合被修改了，那么方法的返回结果将是不确定的
     */
    <T> T invokeAny(Collection<? extends Callable<T>> tasks,
                    long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException;
}