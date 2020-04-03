package file.buffered;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReaderTest {
    
    /**
     * BufferedReader 读
     */
    public static String read(String filename) throws Exception {
        // 构造FileInputReader 引用传给 BufferedReader 构造器进行缓冲读
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        // readLine() 返回null 的时候，就到达了文件末尾
        while ((s = in.readLine()) != null)
            sb.append(s + "\n");
        in.close();
        return sb.toString();
    }
}
