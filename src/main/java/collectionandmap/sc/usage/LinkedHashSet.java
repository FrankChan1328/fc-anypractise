package collectionandmap.sc.usage;

import java.util.Collection;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;

/**
 * LinkedHashSet 虽然继承的是 HashSet，但是其却使用 LinkedHashMap 做为实现类。
 * <p> 三个参数的构造函数使用的是 LinkedHashMap
 * 而 LinkedHashMap 则本身维护了元素的插入顺序
 */
public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, java.io.Serializable {

    private static final long serialVersionUID = -2851667679971038690L;

    public LinkedHashSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor, true);
    }

    public LinkedHashSet(int initialCapacity) {
        super(initialCapacity, .75f, true);
    }
    
    public LinkedHashSet() {
        super(16, .75f, true);
    }

    public LinkedHashSet(Collection<? extends E> c) {
        super(Math.max(2 * c.size(), 11), .75f, true);
        addAll(c);
    }

    @Override
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this, Spliterator.DISTINCT | Spliterator.ORDERED);
    }
}