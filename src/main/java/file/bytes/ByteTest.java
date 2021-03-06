package file.bytes;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 二进制文件读写
 */
public class ByteTest {
	/**
	 * java.io包中的OutputStream及其子类专门用于写二进制数据。
	 * <p>
	 * FileOutputStream是其子类，可用于将二进制数据写入文件。
	 * <p>
	 * DataOutputStream是OutputStream的另一个子类，它可以
	 * <p>
	 * 连接到一个FileOutputStream上，便于写各种基本数据类型的数据。
	 */
	public void writeMethod1() {
		String fileName = "D:/test/kuka1.dat";
		int value0 = 255;
		int value1 = 0;
		int value2 = -1;
		try {
			// 将DataOutputStream与FileOutputStream连接可输出不同类型的数据
			// FileOutputStream类的构造函数负责打开文件kuka.dat，如果文件不存在，
			// 则创建一个新的文件，如果文件已存在则用新创建的文件代替。然后FileOutputStream
			// 类的对象与一个DataOutputStream对象连接，DataOutputStream类具有写
			// 各种数据类型的方法。
			DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName));
			out.writeInt(value0);
			out.writeInt(value1);
			out.writeInt(value2);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 对于大量数据的写入，使用缓冲流BufferedOutputStream类可以提高效率
	public void writeMethod2() {
		String fileName = "D:/test/kuka1.dat";
		try {
			DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
			out.writeInt(10);
			System.out.println(out.size() + " bytes have been written.");
			out.writeDouble(31.2);
			System.out.println(out.size() + " bytes have been written.");
			out.writeBytes("JAVA");
			System.out.println(out.size() + " bytes have been written.");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 对二进制文件比较常见的类有FileInputStream，DataInputStream
	 * <p>
	 * BufferedInputStream等。类似于DataOutputStream，DataInputStream
	 * <p>
	 * 也提供了很多方法用于读入布尔型、字节、字符、整形、长整形、短整形、单精度、双精度等数据。
	 */
	public void readMethod1() {
		String fileName = "D:/test/kuka1.dat";
		int sum = 0;
		try {
			DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
			sum += in.readInt();
			sum += in.readInt();
			sum += in.readInt();
			System.out.println("The sum is:" + sum);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readMethod2() {
		try {
			FileInputStream stream = new FileInputStream("D:/test/kuka1.dat");
			int c;
			while ((c = stream.read()) != -1) {
				System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
