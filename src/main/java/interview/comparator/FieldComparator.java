package interview.comparator;

import java.lang.reflect.Method;
import java.util.Comparator;

import interview.Extension;

/**
 * 按属性自然排序
 */
public class FieldComparator implements Comparator<Extension> {
    private String field;

    public FieldComparator(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    @Override
    public int compare(Extension o1, Extension o2) {
        String o1Value = MethodHandler.getValue(o1, field);
        String o2Value = MethodHandler.getValue(o2, field);
        
        if (null == o1Value || null == o2Value) {
            return null == o1Value ? ((null == o2Value) ? 0 : 1) : -1;
        }
        
        return o1Value.compareTo(o2Value);
    }

    static class MethodHandler {
        /**
         * 获取object 属性名为field 的属性值
         * 
         * @param object 模板对象
         * @param field 目标属性名
         * @return 属性值，可能为null
         */
        public static <T, E> E getValue(T object, String field) {
            return getMethodValue(object, getMethodName(field));
        }

        private static String getMethodName(String field) {
            return "get" + field.substring(0, 1).toUpperCase() + field.substring(1, field.length());
        }

        @SuppressWarnings("unchecked")
        private static <T, E> E getMethodValue(T object, String methodName) {
            Class<?> clazz = object.getClass();
            Method[] methods = clazz.getMethods();
            try {
                for (Method method : methods) {
                    if (method.getName().equals(methodName)) {
                        return (E) method.invoke(object);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
