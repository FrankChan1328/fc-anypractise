package thread.executor.test.func;

import java.util.Random;
import java.util.concurrent.Callable;

public class ServiceCheckFunc implements Callable<String> {
	private int count;
	
	public ServiceCheckFunc(int count){
		this.count = count;
	}

	@Override
	public String call() throws Exception {
		System.out.println("count:" + count + " ,服务 检查!");
		int r = new Random().nextInt(4) * 1000;
		Thread.sleep(r);
		return count + " " + r;
	}

}
