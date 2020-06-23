package zk.util;

public class ZKClient {
    private ZKConnection conn;
    
    public ZKClient(String zkHost){
        conn = new ZKConnection(zkHost);
    }
    
    public void create(String path, byte[] data) {
        conn.create(path, data);
    }
    
    public Object getZNodeData(String path, boolean watchFlag) {
        return conn.getZNodeData(path, watchFlag);
    }
    
    public boolean update(String path, byte[] data) {
        return conn.update(path, data);
    }
    
    public void close(){
        try {
            conn.close();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
