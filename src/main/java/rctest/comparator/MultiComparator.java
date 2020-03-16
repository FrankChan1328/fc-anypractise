package rctest.comparator;

import java.util.Comparator;
import java.util.List;

/**
 * 支持多个Comparator 自由组合使用
 */
public class MultiComparator<T> implements Comparator<T> {
    private final List<Comparator<T>> comparators;

    public MultiComparator(List<Comparator<T>> comparators) {
        this.comparators = comparators;
    }

    public int compare(T o1, T o2) {
        if (null != comparators && !comparators.isEmpty()) {
            for (Comparator<T> c : comparators) {
                int result = c.compare(o1, o2);
                if (result != 0) {
                    return result;
                }
            }
        }
        return 0;
    }
}
