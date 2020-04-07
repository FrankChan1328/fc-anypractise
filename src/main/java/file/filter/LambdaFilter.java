package file.filter;

import java.io.File;
import java.io.FileFilter;

public class LambdaFilter {
	public static void main(String[] args) {
		fileFilter();
		
		fileFilterUseRefer();
	}

	/**
	 * 筛选隐藏的文件
	 */
	public static void fileFilter() {
		File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
			public boolean accept(File file) {
				return file.isHidden();
			}
		});
	}

	/**
	 * 使用Java 8 引用
	 */
	public static void fileFilterUseRefer() {
		File[] hiddenFiles = new File(".").listFiles(File::isHidden);
	}

}
