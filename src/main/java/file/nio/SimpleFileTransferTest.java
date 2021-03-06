package file.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class SimpleFileTransferTest {

	public static void main(String[] args) throws IOException {
		SimpleFileTransferTest simpleFileTransferTest = new SimpleFileTransferTest();
		File sourse = new File("C:\\test\\1.qlv");
		File des = new File("C:\\\\test\\io.qlv");
		File nio = new File("C:\\\\\\\\test\\\\nio.qlv");

		long time = simpleFileTransferTest.transferFile(sourse, des);
		System.out.println(time + "：普通字节流时间");

		long timeNio = simpleFileTransferTest.transferFileWithNIO(sourse, nio);
		System.out.println(timeNio + "：NIO时间");
	}
	
	private long transferFile(File source, File des) throws IOException {
		long startTime = System.currentTimeMillis();

		if (!des.exists())
			des.createNewFile();

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des));

		// 将数据源读到的内容写入目的地--使用数组
		byte[] bytes = new byte[1024 * 1024];
		int len;
		while ((len = bis.read(bytes)) != -1) {
			bos.write(bytes, 0, len);
		}

		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

	private long transferFileWithNIO(File source, File des) throws IOException {
		long startTime = System.currentTimeMillis();

		if (!des.exists())
			des.createNewFile();

		RandomAccessFile read = new RandomAccessFile(source, "rw");
		RandomAccessFile write = new RandomAccessFile(des, "rw");

		FileChannel readChannel = read.getChannel();
		FileChannel writeChannel = write.getChannel();

		// 1M缓冲区
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);

		while (readChannel.read(byteBuffer) > 0) {
			byteBuffer.flip();
			writeChannel.write(byteBuffer);
			byteBuffer.clear();
		}

		writeChannel.close();
		readChannel.close();
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
}
