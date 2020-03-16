package rctest.comparator.extension;

import java.util.HashMap;
import java.util.Map;

import rctest.Extension;

/**
 * Extension 类ExtType 属性排序
 * <p> 排序规则： sort by User > Dept > AO > TMO > Other;
 */
public class ExtTypeComparator extends BaseComparator {
    private static final Integer EXTTYPE_USER = 1;
    private static final Integer EXTTYPE_DEPT = 2;
    private static final Integer EXTTYPE_AO = 3;
    private static final Integer EXTTYPE_TMO = 4;
    private static final Integer EXTTYPE_OTHER = 5;
    
    private static final Map<String, Integer> PRIORITY_MAP;
    static {
        PRIORITY_MAP = new HashMap<>();
        PRIORITY_MAP.put("Other", EXTTYPE_OTHER);
        PRIORITY_MAP.put("TMO", EXTTYPE_TMO);
        PRIORITY_MAP.put("AO", EXTTYPE_AO);
        PRIORITY_MAP.put("Dept", EXTTYPE_DEPT);
        PRIORITY_MAP.put("User", EXTTYPE_USER);
    }
    
    @Override
    public int compare(Extension o1, Extension o2) {
        return getValue(o1.getExtType()).compareTo(getValue(o2.getExtType()));
    }
    
    private Integer getValue(String extType) {
        if (!PRIORITY_MAP.containsKey(extType)) {
            return EXTTYPE_OTHER;
        }
        return PRIORITY_MAP.get(extType);
    }
}
