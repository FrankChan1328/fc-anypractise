package thread.atomic;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsoleTest implements Runnable{
	private Map<Integer,AtomicInteger> map;
	
	Lock lock = new ReentrantLock();
	
	public ConsoleTest(Map<Integer,AtomicInteger> map){
		this.map = map;
	}

	@Override
	public void run() {
		int r = (int) (Math.random() * 100);
		if(r%2 ==0){
			AtomicInteger value = map.get(0);
			
//			try {
//				Thread.sleep((long) (Math.random() * 10));
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			
			if(r%6 == 0){
//				System.out.println("当前:"+r +" 被6整除");
				if(value.get() < 3){
//					System.out.println("here1 "+ value.get());
					value.getAndIncrement();
				}
				else{
//					System.out.print("here2 "+ value.get());
//					System.out.println(map);
				}
			}
		}
		
		
		if (r % 7 == 0 && r%2 !=0) {
			AtomicInteger value = map.get(1);
//			System.out.println("当前:" + r + " 被3整除为2");
			if (value.get() < 3) {
//				System.out.println("here3 " + value.get());
				value.getAndIncrement();
			} else {
//				System.out.print("here4 " + value.get());
//				System.out.println(map);
			}
		}
	}
}
