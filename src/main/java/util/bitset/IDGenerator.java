package util.bitset;

import java.util.BitSet;

/**
 * 使用场景：最小可用ID
 * <p>在一些系统中，需要进行ID的生成，同时待生成的ID需要是未使用的ID集中的最小一个。
 * <p>当ID使用完毕后，需要通知系统进行回收，以便下一次使用。
 * <p>常见的比如在Linux系统中，每个进程维护一个打开的文件描述符表，当进程需要打开新的文件时，便需要找一个不在已打开的文件描述符表中的最小 描述符。
 * 当进程关闭文件时，其对应的文件描述符便会被回收，下次重复使用。利用位图，可以比较高效的实现上面的功能。
 *
 */
public class IDGenerator {
	private BitSet bitset;

	public IDGenerator(int maxfds) {
		bitset = new BitSet(maxfds);
	}

	public int open() {
		int unused = bitset.nextClearBit(0);
		bitset.set(unused);
		return unused;
	}

	public void close(int id) {
		bitset.clear(id);
	}

	@Override
	public String toString() {
		return bitset.toString();
	}

	public static void main(String args[]) {
		IDGenerator gen = new IDGenerator(1 << 16);
		// 默认打开标准输入，标准输出，标准错误
		int stdin = gen.open();
		int stdout = gen.open();
		int stderr = gen.open();
		System.out.println("当前打开: " + gen);

		int id = gen.open();
		System.out.println("新id为: " + id);

		gen.close(stdin);
		System.out.println("关闭 " + stdin + ", 当前打开: " + gen);

		id = gen.open();
		System.out.println("新的id为: " + id);
		System.out.println("当前打开: " + gen);
	}
}
