package redis.jedis.pubsubpersist;

public class TestMain {

	public static void main(String[] args) throws Exception {
		String host = "127.0.0.1";
		int port = 6379;
		String clientId = "myclient";
		Publisher pubClient = new Publisher(host, port);

		final String channel = "mychannel";
		final Subscribe subClient = new Subscribe(host, port, clientId);

		Thread subThread = new Thread(new Runnable() {
			public void run() {
				System.out.println("------------sub----start------------");
				subClient.sub(channel);
				System.out.println("------------sub----end------------");
			}
		});

		subThread.setDaemon(true);
		subThread.start();
		int i = 0;
		while (i < 20) {
			String message = "message--" + i;
			pubClient.pub(channel, message);
			i++;
			Thread.sleep(100);
		}
		subClient.unsubscribe(channel);

	}
}
