package redis.jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class PureJedisDemo {
	
	private static final String HOST = "localhost";
	private static final int PORT = 6379;
	

	public static void main(String[] args) {
		Jedis jedis = new Jedis(HOST, PORT);
		
		// 操作字符串
//		jedis.set("stringKey1", "stringValue");
//		String stringValue = jedis.get("stringKey1");
//		System.out.println(stringValue);
		
		// 操作list
//		jedis.lpush("queue:jobs", "job-one");
//		jedis.lpush("queue:jobs", "job-two");
//		String job = jedis.rpop("queue:jobs");
//		System.out.println(job);
		
		// 操作sets
//		jedis.sadd("connected-users", "user1"); 
//		jedis.sadd("connected-users", "user2");
//		jedis.sadd("connected-users", "user3");
//		
//		//remove members
//		jedis.srem("connected-users", "user2");
//		//get set
//		Set<String> connectedUserIds = jedis.smembers("connected-users");
//		System.out.println(connectedUserIds);
//		//check membership
//		boolean isUserConnected = jedis.sismember("connected-users", "user1");
//		System.out.println(isUserConnected);
		
		
		
		
		// 操作hash
//		jedis.hset("users:user1", "name", "John");
//		jedis.hset("users:user1", "age", "25");
//		String name = jedis.hget("users:user1", "name");
//		System.out.println(name);
//		
//		Map<String, String> entries = jedis.hgetAll("users:user1");
//		Integer age = Integer.parseInt(entries.get("age")); //25
//		System.out.println(age);
		
		
		
		
//		// 操作 Sorted Sets
//		Map<String, Double> ranks = new HashMap<>();
//		ranks.put("user1", 10d);
//		ranks.put("user2", 5d);
//		ranks.put("user3", 8d);
//		
//		ranks.keySet().forEach(user -> {
//			jedis.zadd("ranks", ranks.get(user), user);
//		});
//		
//		String player = jedis.zrevrange("ranks", 0, 1).iterator().next(); //user1 - since they have the highest rank
//		System.out.println(player);
//		long rankOfUser2 = jedis.zrevrank("ranks", "user2"); //1. Since ranks are zero based
//		System.out.println(rankOfUser2);
//		
		
		
		jedis.close();
	
	}

}
