package file.cases.mmf;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MmfUtil {
    public static Path getPath(String fileName) {
        ClassLoader classLoader = MmfReadTest.class.getClassLoader();
        String pathStr = classLoader.getResource(fileName).getPath();
        // windows 环境下，去掉路径最开始的/
        if (isWindows()) {
            pathStr = pathStr.replaceFirst("/", "");
        }
        return Paths.get(pathStr);

    }
    
    public static boolean isWindows() {
        String os = System.getProperty("os.name");
        return os.startsWith("Win");
    }
}
