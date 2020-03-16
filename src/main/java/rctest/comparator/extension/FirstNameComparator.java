package rctest.comparator.extension;

import rctest.Extension;

/**
 * Extension 类 FirstName属性排序
 */
public class FirstNameComparator extends BaseComparator {

    @Override
    public int compare(Extension o1, Extension o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }

}
