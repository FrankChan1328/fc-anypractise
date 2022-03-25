package redis.nettyredission;

import java.util.List;
import java.util.Random;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.protocol.pubsub.Message;
import org.redisson.client.protocol.pubsub.PubSubMessage;
import org.redisson.config.Config;

public class RedisDemo {
	private static final String SINGLE_SERVER = "redis://localhost:6379";
	
	public static void main(String[] args) {
		Config redissonConfig = new Config();
		redissonConfig.useSingleServer().setAddress(SINGLE_SERVER);
		RedissonClient redisson = Redisson.create(redissonConfig);

		List<Integer> list = redisson.getList("list");
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

//		Message message = new PubSubMessage("text_"+new Random().nextInt());
//		List<Message> msgList = redisson.getList("msgList");
//		msgList.add(message);
	}

}
