package thread.executor.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MainTest {

	public static void main(String[] args) throws Exception, ExecutionException {
		long t1 = System.currentTimeMillis();
		Map<Integer, Future<DemoResult>> futureMap = new HashMap<>();
		for (int i = 0; i < 3; i++) {
			CheckJob job = new CheckJob(i);
			Future<DemoResult> future = FixedThreadPoolExecutorDemo.addTask(job);
			futureMap.put(i, future);
		}
		long t2 = System.currentTimeMillis();
		System.out.println("时间1:"+ (t2-t1));

		for (Map.Entry<Integer, Future<DemoResult>> entry : futureMap.entrySet()) {
			DemoResult result = entry.getValue().get();
			System.out.println("结果处理:" + entry.getKey() + " " + result.getIpMsg() + "_" + result.getSvcMsg());
		}
		long t3 = System.currentTimeMillis();
		System.out.println("时间3:"+ (t3-t2));
	}

}
