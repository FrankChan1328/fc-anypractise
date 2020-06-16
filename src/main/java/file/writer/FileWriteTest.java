package file.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWriteTest {

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>(Arrays.asList("1","2","3"));
        
        String fileName = "E:\\tmp\\test.txt";
        FileWriter writer = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(writer);
        
        for(String str : list){
            bw.write(str);
            bw.newLine(); //写入换行
        }

        bw.close();
        writer.close();
    }

}
