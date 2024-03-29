package redis;

import redis.clients.jedis.Jedis;

public class ErrorRedisTool {
	/**
	 * 网上之所以有人这样实现，是因为低版本的jedis并不支持多参数的set()方法
	 */
	public static void wrongGetLock1(Jedis jedis, String lockKey, String requestId, int expireTime) {
	    Long result = jedis.setnx(lockKey, requestId);
	    if (result == 1) {
	        // 若在这里程序突然崩溃，则无法设置过期时间，将发生死锁
	        jedis.expire(lockKey, expireTime);
	    }
	}
	
	/**
	 * key是锁， 把vlaue 设置成过期时间
	 * 问题：
	 * 1).由于是客户端自己生成过期时间，所以需要强制要求分布式下每个客户端的时间必须同步
	 * 2).当锁过期的时候，如果多个客户端同时执行jedis.getSet()方法，那么虽然最终只有一个客户端可以加锁，但是这个客户端的锁的过期时间可能被其他客户端覆盖
	 * 3). 锁不具备拥有者标识，即任何客户端都可以解锁
	 */
	public static boolean wrongGetLock2(Jedis jedis, String lockKey, int expireTime) {
	    long expires = System.currentTimeMillis() + expireTime;
	    String expiresStr = String.valueOf(expires);

	    // 如果当前锁不存在，返回加锁成功
	    if (jedis.setnx(lockKey, expiresStr) == 1) {
	        return true;
	    }

	    // 如果锁存在，获取锁的过期时间
	    String currentValueStr = jedis.get(lockKey);
	    if (currentValueStr != null && Long.parseLong(currentValueStr) < System.currentTimeMillis()) {
	        // 锁已过期，获取上一个锁的过期时间，并设置现在锁的过期时间
	        String oldValueStr = jedis.getSet(lockKey, expiresStr);
	        if (oldValueStr != null && oldValueStr.equals(currentValueStr)) {
	            // 考虑多线程并发的情况，只有一个线程的设置值和当前值相同，它才有权利加锁
	            return true;
	        }
	    }

	    // 其他情况，一律返回加锁失败
	    return false;

	}
	
	/**
	 * 直接使用jedis.del()方法删除锁，这种不先判断锁的拥有者而直接解锁的方式，会导致任何客户端都可以随时进行解锁，即使这把锁不是它的
	 */
	public static void wrongReleaseLock1(Jedis jedis, String lockKey) {
	    jedis.del(lockKey);
	}
	
	/**
	 * 问题在于如果调用jedis.del()方法的时候，这把锁已经不属于当前客户端的时候会解除他人加的锁。
	 * 那么是否真的有这种场景？
	 * 答案是肯定的，比如客户端A加锁，一段时间之后客户端A解锁，在执行jedis.del()之前，锁突然过期了，
	 * 此时客户端B尝试加锁成功，然后客户端A再执行del()方法，则将客户端B的锁给解除了。
	 */
	public static void wrongReleaseLock2(Jedis jedis, String lockKey, String requestId) {
	    // 判断加锁与解锁是不是同一个客户端
	    if (requestId.equals(jedis.get(lockKey))) {
	        // 若在此时，这把锁突然不是这个客户端的，则会误解锁
	        jedis.del(lockKey);
	    }

	}
}
