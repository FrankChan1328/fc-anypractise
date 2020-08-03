package nio.buffer.mappedbytebuffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBufferTest {

    public static void main(String[] args) throws IOException {
        RandomAccessFile rw = new RandomAccessFile("1.txt", "rw");
        FileChannel rwChannel = rw.getChannel();
        // size：1.txt 的多少个字节映射到内存
        MappedByteBuffer mappedByteBuffer = rwChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        mappedByteBuffer.put(0, (byte) 'H');
        mappedByteBuffer.put(3, (byte) '9');

        rw.close();
        rwChannel.close();
    }

}
