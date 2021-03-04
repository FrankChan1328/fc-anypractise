
package thread.executor.test;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import thread.executor.test.func.IpCheckFunc;
import thread.executor.test.func.ServiceCheckFunc;

public class CheckJob implements Callable<DemoResult> {
	private int count;

	public CheckJob(int count) {
		this.count = count;
	}

	@Override
	public DemoResult call() throws Exception {
		long t1 = System.currentTimeMillis();
		DemoResult result = new DemoResult();
		Future<String> ipResult = FixedThreadPoolExecutorDemo.addTask(new IpCheckFunc(count));
		Future<String> serviceResult = FixedThreadPoolExecutorDemo.addTask(new ServiceCheckFunc(count));
		result.setIpMsg(ipResult.get());
		result.setSvcMsg(serviceResult.get());
		long t2 = System.currentTimeMillis();
		System.out.println("CheckJob时间:"+ (t2-t1));
		return result;
	}

}
