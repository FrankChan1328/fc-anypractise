package interview.test;

import java.util.Arrays;
import java.util.HashSet;
import org.junit.Assert;
import org.junit.Test;
import interview.Utils;

public class GetUnUsedKeysTest {

    @Test
    public void getUnUsedKeysNormalTest() {
        // 常规检查
        int[] allKeys = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] usedKeys = { 1, 2, 3 };
        int[] unUsedKeys = Utils.getUnUsedKeys(allKeys, usedKeys);

        Integer[] target = { 4, 5, 6, 7, 8, 9 };
        HashSet<Integer> sets = new HashSet<>(Arrays.asList(target));
        //
        for (int i = 0; i < unUsedKeys.length; i++) {
            Assert.assertTrue(sets.contains(unUsedKeys[i]));
        }
    }

    @Test
    public void getUnUsedKeysIllegalTest1() {
        // 非法数据检查，all keys数组 为空
        int[] allKeysEmpty = {};
        int[] usedKeysEmpty = { 1, 2, 3 };
        int[] unUsedKeysEmpty = Utils.getUnUsedKeys(allKeysEmpty, usedKeysEmpty);
        Assert.assertTrue(null == unUsedKeysEmpty || unUsedKeysEmpty.length == 0);
    }

    @Test
    public void getUnUsedKeysIllegalTest2() {
        // 非法数据检查， used keys 为空
        int[] allKeysEmpty = { 1, 2, 3 };
        int[] usedKeysEmpty = {};
        int[] unUsedKeys = Utils.getUnUsedKeys(allKeysEmpty, usedKeysEmpty);
        Assert.assertTrue(unUsedKeys.length == 3 && unUsedKeys[0] == 1 && unUsedKeys[1] == 2 && unUsedKeys[2] == 3);
    }
    
    @Test
    public void getUnUsedKeysTest() {
        // used keys 中有数字3，在 allkeys 中不存在
        int[] allKeys = { 1, 4, 9, 6, 7, 5};
        int[] usedKeys = { 1, 2, 3 };
        int[] unUsedKeys = Utils.getUnUsedKeys(allKeys, usedKeys);
        
        Integer[] target = { 4, 9, 6, 7, 5 };
        HashSet<Integer> sets = new HashSet<>(Arrays.asList(target));
        
        Assert.assertFalse(sets.contains(3));
        Assert.assertTrue(sets.size() == target.length);
        
        for (int i = 0; i < unUsedKeys.length; i++) {
            Assert.assertTrue(sets.contains(unUsedKeys[i]));
        }
    }
}
