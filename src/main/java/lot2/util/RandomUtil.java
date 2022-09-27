package lot2.util;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RandomUtil {
    
    public static int getARandom(int min, int max) {
        int num = min + (int) (Math.random() * (max - min + 1));
        return num;
    }

    public static List<Integer> getRandoms(int min, int max, int size) {
        HashSet<Integer> hs = new HashSet<>();
        for (;;) {
            int num = min + (int) (Math.random() * (max - min + 1));
            hs.add(num);
            if (hs.size() == size)
                break;
        }
        return hs.stream().sorted().collect(Collectors.toList());
    }
    
    public static List<Integer> getTotal() {
        List<Integer> list = getRandoms(1, 35, 5);
        list.addAll(getRandoms(1, 12, 2));
        return list;
    }
}
