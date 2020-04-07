package file.operate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperate {

	public static void main(String[] args) {
	}

	/**
	 * 将一个文件内容拷贝到另外一个文件里
	 */
	public static void fileCopy() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("D:\\test.txt");
		FileOutputStream fos = new FileOutputStream("D:\\test2.txt");
		int c;
		try {
			// 到达文件末尾返回 -1
			while ((c = fis.read()) != -1) {
				fos.write(c);
			}
			fis.close();
			fos.close();
		} catch (IOException e) {
		}
	}

}
