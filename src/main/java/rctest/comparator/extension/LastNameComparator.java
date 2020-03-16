package rctest.comparator.extension;

import rctest.Extension;

/**
 * Extension 类 LastName 属性排序
 */
public class LastNameComparator extends BaseComparator {

    @Override
    public int compare(Extension o1, Extension o2) {
        return compareStr(o1.getLastName(), o2.getLastName());
    }
}
