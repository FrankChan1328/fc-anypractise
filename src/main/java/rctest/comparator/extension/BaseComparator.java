package rctest.comparator.extension;

import java.util.Comparator;

import rctest.Extension;

/**
 * Extension 类 Base Comparator
 */
public class BaseComparator implements Comparator<Extension> {
    private static final int INT_EQUAL = 0;
    private static final int INT_AHEAD = -1;
    private static final int INT_BEHIND = 1;

    @Override
    public int compare(Extension o1, Extension o2) {
        return 0;
    }

    /**
     * 比较两个字符串,如果字符串相同，则返回0；
     * null 的字符串优先级最低
     * @param str1
     * @param str2
     * @return
     */
    public int compareStr(String str1, String str2) {
        if (null == str1 && null == str2) {
            return INT_EQUAL;
        }
        if (null == str1 || null == str2) {
            return (null == str1) ? INT_BEHIND : INT_AHEAD;
        }
        return str1.compareTo(str2);
    }
}
