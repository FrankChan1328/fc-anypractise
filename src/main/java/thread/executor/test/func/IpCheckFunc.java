package thread.executor.test.func;

import java.util.Random;
import java.util.concurrent.Callable;

public class IpCheckFunc implements Callable<String> {
	private int count;
	
	public IpCheckFunc(int count){
		this.count = count;
	}
	
	@Override
	public String call() throws Exception {
		System.out.println("count:" + count + " ,IP 检查!");
		int r = new Random().nextInt(2) * 1000;
		Thread.sleep(r);
		return count + " " + r;
	}
}
