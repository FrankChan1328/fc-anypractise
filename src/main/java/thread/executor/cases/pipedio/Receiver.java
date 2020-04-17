package thread.executor.cases.pipedio;

import java.io.IOException;
import java.io.PipedReader;

public class Receiver implements Runnable {
    private PipedReader in;

    public Receiver(Sender sender) throws IOException {
        in = new PipedReader(sender.getPipedWriter());
    }

    @Override
    public void run() {
        try {
            while (true) {
                // 在读取到内容之前，会一直阻塞
                char s = (char) in.read();
                System.out.println("Read: " + s + ", ");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage() + " Receiver read exceiption!!!");
        }
    }

}
