package zk.util;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

public class ZKConnection {
    private ZooKeeper zoo;
    private CountDownLatch connectionLatch = new CountDownLatch(1);
    private int DEFAULT_SESSION_TIME_OUT = 2000;
    
    public ZKConnection(String zkHost){
        zoo = connect(zkHost, DEFAULT_SESSION_TIME_OUT);
    }
    
    public ZKConnection(String zkHost, int sessionTimeOut){
        zoo = connect(zkHost, sessionTimeOut);
    }

    private ZooKeeper connect(String host, int sessionTimeOut) {
        try{
            zoo = new ZooKeeper(host, sessionTimeOut,  new Watcher() {
                public void process(WatchedEvent we) {
                    if (we.getState() == KeeperState.SyncConnected) {
                        connectionLatch.countDown();
                    }
                }
            });
            connectionLatch.await();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return zoo;
    }
    
    public Object getZNodeData(String path, boolean watchFlag) {
        try {
            byte[] b = null;
            b = zoo.getData(path, null, null);
            return new String(b, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean create(String path, byte[] data){
        try {
            zoo.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean update(String path, byte[] data){
        try{
            int version = zoo.exists(path, true).getVersion();
            zoo.setData(path, data, version);
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public void close() throws InterruptedException {
        zoo.close();
    }
}
