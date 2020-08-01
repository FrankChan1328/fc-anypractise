package nio.buffer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ByteBufferTest {
	private static final int SIZE = 1024;
	private static final String FILE = "data.txt";

	public static void main(String[] args) throws Exception {
		write();
		writeInFileEnd();
		read();
	}

	public static void write() throws Exception {
		// 获取通道，该通道允许写操作
		FileOutputStream fos = new FileOutputStream(FILE);
		FileChannel fc = fos.getChannel();
		// 将字节数组包装到缓冲区中
		fc.write(ByteBuffer.wrap("Some text".getBytes()));
		// 关闭通道
		fc.close();
		fos.close();
	}
	
	/**
	 * 在文件末尾继续写
	 */
	public static void writeInFileEnd() throws Exception {
		RandomAccessFile raf = new RandomAccessFile("data.txt", "rw");
		// 随机读写文件流创建的管道
		FileChannel fc = raf.getChannel();
		// fc.position()计算从文件的开始到当前位置之间的字节数
		System.out.println("此通道的文件位置：" + fc.position());
		// 设置此通道的文件位置,fc.size()此通道的文件的当前大小,该条语句执行后，通道位置处于文件的末尾
		fc.position(fc.size());
		// 在文件末尾写入字节
		fc.write(ByteBuffer.wrap("Some more".getBytes()));
		fc.close();

		raf.close();
	}
	
	public static void read() throws Exception {
		FileInputStream fis = new FileInputStream("data.txt");
		// 用通道读取文件
		FileChannel fc = fis.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(SIZE);
		// 将文件内容读到指定的缓冲区中
		fc.read(buffer);
		buffer.flip();// 此行语句一定要有
		while (buffer.hasRemaining()) {
			System.out.print((char) buffer.get());
		}
		fc.close();
		fis.close();
	}
}
