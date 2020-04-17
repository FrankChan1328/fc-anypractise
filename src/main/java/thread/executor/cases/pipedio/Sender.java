package thread.executor.cases.pipedio;

import java.io.IOException;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Sender implements Runnable {

    private Random rand = new Random(47);
    private PipedWriter out = new PipedWriter();
    
    public PipedWriter getPipedWriter(){
        return out;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (char c = 'A'; c <= 'z'; c++) {
                    // sender 把数据放进out ，然后休眠一段时间(随机数)
                    // Receiver没有sleep()和wait,当它调用read()时，如果没有更多的数据，管道将自动阻塞。
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(400));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("sender is interrupted!");
            e.printStackTrace();
        }
    }
}
