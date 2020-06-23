package file.cases.readbigfile;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

import com.github.shyiko.mysql.binlog.BinaryLogFileReader;
import com.github.shyiko.mysql.binlog.event.Event;
import com.github.shyiko.mysql.binlog.event.deserialization.ChecksumType;
import com.github.shyiko.mysql.binlog.event.deserialization.EventDeserializer;

/**
 * 读取超大文件
 */
public class ReadBigFile {
    
    public static void main(String [] args) throws IOException{
        readBinLog();
    }
    
    /**
     * 方法一：使用BufferedReader 读写超大文件
     * <p>
     * 分配5M 缓存读取
     */
    public static void readBigFile(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis, "utf-8"), 5 * 1024 * 1024);
        // 用5M的缓冲读取文本文件

        String line = "";
        while ((line = reader.readLine()) != null) {
            // do biz
        }
        reader.close();
    }

    /**
     * 方法二：使用RandomAccessFile 读取N G的msql bin 文件
     */
    public static void readBinLog() throws IOException {
        String filePath = "E:\\tmp\\mysql-bin.002699";
        File binlogFile = new File(filePath);
        EventDeserializer eventDeserializer = new EventDeserializer();
        eventDeserializer.setChecksumType(ChecksumType.CRC32);
        BinaryLogFileReader reader = new BinaryLogFileReader(binlogFile, eventDeserializer);
        for (Event event; (event = reader.readEvent()) != null;) {
//            System.out.println(event.toString());
            write(event.toString());
        }
        reader.close();
    }

    public static void write(String content) throws IOException {
        String tt = "E:\\tmp\\mysql-bin.002699.txt";
        // 打开一个随机访问文件流，按读写方式
        RandomAccessFile randomFile = new RandomAccessFile(tt, "rw");
        // 文件长度,字节数
        long fileLength = randomFile.length();
        // 将写文件指针移到文件尾。
        randomFile.seek(fileLength);
        randomFile.writeBytes(content);
        randomFile.close();
    }
}
