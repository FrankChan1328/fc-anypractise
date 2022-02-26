
package rctest.comparator.extension;

import rctest.Extension;

/**
 * Extension 类Ext 属性排序
 */
public class ExtComparator extends BaseComparator {

    @Override
    public int compare(Extension o1, Extension o2) {
        return compareStr(o1.getExt(), o2.getExt());
    }
}
