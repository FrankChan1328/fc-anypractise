package file.cases.mmf;

import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.nio.file.Path;

/**
 * 内存映射文件读取测试
 */
public class MmfReadTest {
    private static final String FILE_NAME = "mmf.txt";
    
    public static void main(String[] args) {
        CharBuffer charBuffer = null;
        Path path = MmfUtil.getPath(FILE_NAME);
        // 说明：FileChannel.size() 是文件的大小
        try (FileChannel fileChannel = FileChannel.open(path)) {
            // fileChannel.size ==> 80
            MappedByteBuffer mappedByteBuffer = fileChannel.map(MapMode.READ_ONLY, 0, fileChannel.size());
            if (mappedByteBuffer != null) {
                // decode，从内存中读取而不是从磁盘中读取，所以将会很快
                charBuffer = Charset.forName("UTF-8").decode(mappedByteBuffer);
            }
            System.out.println(charBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
