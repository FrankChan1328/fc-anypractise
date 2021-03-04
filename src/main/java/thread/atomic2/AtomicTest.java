package thread.atomic2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

//	public volatile Map<Integer,AtomicInteger> map;
	
//	public Map<Integer,AtomicInteger> map;
	public Map<Integer,Integer> map;
	
	
	public static void main(String[] args) {
//		volatile AtomicInteger inc = new AtomicInteger();
//		System.out.println(inc);
		
		AtomicTest test = new AtomicTest();
		test.test();
		
	}
	
	private void test(){
//		map = new ConcurrentHashMap<>(10);
		map = new HashMap<>(10);
		map.put(0,  0);
		map.put(1,  0);
		for (int i = 0; i < 1000; i++) {
			new ConsoleTest(map).run();
		}
		while (Thread.activeCount() > 1) // 保证前面的线程都执行完
			Thread.yield();
		System.out.println(map);
	}
}
