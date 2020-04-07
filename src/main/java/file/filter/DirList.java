package file.filter;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {
	public static void main(String[] args) {
		File path = new File(".");
		String[] list;
		if (args.length == 0)
			list = path.list();
		else
			list = path.list(new DirFilter(args[0]));
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list)
			System.out.println(dirItem);
	}
}

/**
 * DirFilter 类存在的唯一原因是 accept() 方法,创建这个类的目的是把 accept() 方法提供给list() 使用，
 * 使list() 可以回调 accept()，进而决定哪些文件包含在列表中。
 * <p>因此这种结构也常常被称为回调，更具体的说这是一种策略模式的例子。
 * 因为 list() 实现了基本的功能，而且按照FileNameFilter 的形式提供了中个策略，以便完善 list() 在提供服务时所需的算法。
 *
 */
class DirFilter implements FilenameFilter {
	private Pattern pattern;

	public DirFilter(String regex) {
		pattern = Pattern.compile(regex);
	}

	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
}
