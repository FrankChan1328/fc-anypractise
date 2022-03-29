package redis.jedis.pubsubpersist;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class Subscribe {

	private Jedis jedis;
	private JedisPubSub listener;
	private String CONSTANT_CLIENTSET = "clientSet";

	public Subscribe(String host, int port, String clientId) {
		jedis = new Jedis(host, port);
		listener = new Listener(clientId, new Jedis(host, port));
		jedis.sadd(CONSTANT_CLIENTSET, clientId);
	}

	public void sub(String channel) {
		jedis.subscribe(listener, channel);
	}

	public void unsubscribe(String channel){
		listener.unsubscribe(channel);
	}

}
