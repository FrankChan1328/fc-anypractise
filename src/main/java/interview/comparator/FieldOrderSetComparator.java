package interview.comparator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import interview.Extension;

/**
 * 根据属性排序，并可以指定属性的优先级顺序
 */
public class FieldOrderSetComparator extends FieldComparator {
    private static final Map<String, Integer> PRIORITY_MAP = new HashMap<>();
    private static final Integer MAP_NO_STR_VALUE = Integer.MAX_VALUE;

    public FieldOrderSetComparator(String field, List<String> orders) {
        super(field);
        setPriority(orders);
    }
    
    private void setPriority(List<String> orders) {
        if (null != orders && orders.size() > 0) {
            for (int i = 0; i < orders.size(); i++) {
                if (!PRIORITY_MAP.containsKey(orders.get(i))) {
                    PRIORITY_MAP.put(orders.get(i), i);
                }
            }
        }
    }

    @Override
    public int compare(Extension o1, Extension o2) {
        String o1Str = MethodHandler.getMethodValue(o1, getField(), NULL_STR);
        String o2Str = MethodHandler.getMethodValue(o2, getField(), NULL_STR);
        Integer o1Value = PRIORITY_MAP.containsKey(o1Str) ? PRIORITY_MAP.get(o1Str) : MAP_NO_STR_VALUE;
        Integer o2Value = PRIORITY_MAP.containsKey(o2Str) ? PRIORITY_MAP.get(o2Str) : MAP_NO_STR_VALUE;
        if (MAP_NO_STR_VALUE.equals(o1Value) && MAP_NO_STR_VALUE.equals(o2Value)) {
            return o1Str.compareTo(o2Str);
        }
        return o1Value.compareTo(o2Value);
    }
}
