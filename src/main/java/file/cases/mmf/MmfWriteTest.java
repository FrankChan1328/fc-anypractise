package file.cases.mmf;

import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class MmfWriteTest {
    private static final String FILE_NAME = "mmf_write.txt";
    
    public static void main(String[] args) {
        CharBuffer charBuffer = CharBuffer.wrap("It is a test!!!");
        Path path = MmfUtil.getPath(FILE_NAME);

        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ, StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING)) {
            MappedByteBuffer mappedByteBuffer = fileChannel.map(MapMode.READ_WRITE, 0, 1024);

            if (mappedByteBuffer != null) {
                mappedByteBuffer.put(Charset.forName("UTF-8").encode(charBuffer));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
