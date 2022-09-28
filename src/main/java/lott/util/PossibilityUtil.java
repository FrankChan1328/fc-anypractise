package lott.util;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Lists;
import lott.entity.Lot;
import lott.entity.NumProbability;
import lot.handle.PredictBase;
import lott.entity.ColType;

public class PossibilityUtil {
    
    /**
     * 获取后区两个数字差值的分布
     */
    public static List<NumProbability> eMarginDist(List<Lot> lots) {
        List<NumProbability> result = Lists.newArrayList();
        List<Integer> list = lots.stream().map(it -> {
            return Math.abs(it.getE01() - it.getE02());
        }).collect(Collectors.toList());
        
        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(it -> it, Collectors.counting()));
        int total = map.values().stream().mapToInt(it->it.intValue()).sum();
        
        map.forEach((k,v) ->{
            Double perc = BaseUtil.getPercentage(v.intValue(), total);
            NumProbability num = new NumProbability(k, perc);
            result.add(num);
        });
        return result;
    }
    
    
    /**
     * 获取下期样本概率
     */
    public static List<NumProbability> calNumPosibility(List<Lot> lots, ColType type) {
        return calNumPosibility(lots, 1, type);
    }
    
    /**
     * 获取指定间隔的样本概率
     * <li> 某个位置，下次(margin)出现某个数字的概率
     * @param lots 待预测的数据样本
     * @param margin 隔几期预测 1：预测下期；2：预测下下期
     * @param eIndex 列号
     * @return
     */
    public static List<NumProbability> calNumPosibility(List<Lot> lots, int margin, ColType type) {
        int total = lots.size();
        int rangeMax = ColType.getRange(type);
        
        List<NumProbability> numPros = Lists.newArrayList();
        for (int i = 1; i <= rangeMax; i++) {
            int num = i;
            Stream<Lot> streams = lots.stream().filter(it -> it.get(type) == num);
            List<Lot> target = streams.collect(Collectors.toList());
            //
            Double frequency = PredictBase.getPercentage(target.size(), total);
            NumProbability current = new NumProbability(num, frequency);
            numPros.add(current);
            
            List<NumProbability> nextPros = Lists.newArrayList();
            // 下下次出现数字
            for (int k = 1; k <= rangeMax; k++) {
                int count = 0;
                int toCompare = k;
                
                for (int j = 0; j < total; j++) {
                    Lot lot = lots.get(j);
                    if (lot.get(type) == num) {
                        if (j < total - margin) {
                            if (lots.get(j + margin).get(type) == toCompare) {
                                count++;
                            }
                        }
                    }
                }
                
                Double frequency2 = PredictBase.getPercentage(count, target.size());
                nextPros.add(new NumProbability(k, frequency2));
            }
            current.setNextPros(nextPros.stream().sorted(Comparator.comparing(NumProbability::getProbability).reversed()).collect(Collectors.toList()));
        }
        return numPros.stream().sorted(Comparator.comparing(NumProbability::getProbability).reversed()).collect(Collectors.toList());
    }
}
