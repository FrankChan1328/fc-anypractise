package zk.demo;

import zk.util.ZKClient;

public class ZkDemo {
    
    private static final String ZK_SERVER_URL = "127.0.0.1:7072";
    private static final String ZK_AUTH_INFO = "demo" +":" +"XXX";
    private static final String ZK_PATH = "/test";
    
    public static void main(String[] args) {
        ZKClient client = new ZKClient(ZK_SERVER_URL);
        
        String data = "This is a test";
        String data2 = "This is a test new!";
        
        client.create(ZK_PATH, data.getBytes());
        
        Object obj = client.getZNodeData(ZK_PATH, true);
        System.out.println(obj);
        
        client.update(ZK_PATH, data2.getBytes());
        Object obj2 = client.getZNodeData(ZK_PATH, true);
        System.out.println(obj2);
    }

}
