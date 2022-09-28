package lott.util;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import lott.entity.NumProbability;
import lott.util.WeightRandom.ItemWithWeight;

public class WeightRandomUtil {
    
    public static Integer getNum(List<NumProbability> results) {
        List<ItemWithWeight<Integer>> list = results.stream().map(it -> {
            ItemWithWeight<Integer> server = new ItemWithWeight<>(it.getNum(), it.getProbability());
            return server;
        }).collect(Collectors.toList());
        WeightRandom<Integer> weightRandom = new WeightRandom<>(list);
        return weightRandom.choose();
    }
    
    /**
    * 
    *  后区(01)与前区一个相同的：13.80
    *  后区(02)与前区一个相同的：13.32
    *  后区(01/02)均存在前区：1.63
    *  后区至少有一个与前区相同：25.49
    *  本次重复，下次继续重复：7.26
    *  本次不重复，下次重复：18.22
    */
    public static List<Integer> get2ExcludeNums(List<Integer> eNums) {
        // 后区与前区至少有一个相同 25.49
        ItemWithWeight<Integer> server1 = new ItemWithWeight<>(1, 25.49);
        // 后区与前区没有相同的 74.51
        ItemWithWeight<Integer> server2 = new ItemWithWeight<>(2, 74.51);

        WeightRandom<Integer> weightRandom = new WeightRandom<>(Lists.newArrayList(server1, server2));
        Integer result = weightRandom.choose();
        if (result.equals(2)) {
            return eNums;
        }
        return Lists.newArrayList();
    }
}
