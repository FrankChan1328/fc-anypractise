package lot2.pre;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import lot.entity.Lot;
import lot.entity.NumProbability;
import lot2.entity.ColType;

public class CalTotal {
    
    /**
     * 过滤数据：
     * <br>1.排除概率最低的两个数据
     * <del>2.排除概率最高的一个数据</del>
     */
    private static int filter(List<NumProbability> sourceNums, List<Integer> list,
            List<Integer> margin2List) {
        List<NumProbability> nums = sourceNums.size() > 2 ? sourceNums.subList(0, sourceNums.size() - 2) : sourceNums;
        
        // 暂不排除概率最高的一个
//        nums = sourceNums.size() > 1 ? nums.subList(1, nums.size()) : nums;
//        int max = list.size() == 0 ? 0 : list.get(list.size() - 1);
        
        List<NumProbability> result = nums.stream().filter(it -> it.getProbability() > 0.)
//                .filter(it -> !list.contains(it.getNum()) && it.getNum() > max)
                .filter(it -> !list.contains(it.getNum()))
                .filter(it -> !margin2List.contains(it.getNum()))
                .collect(Collectors.toList());

        if (result.size() == 1) {
            return result.get(0).getNum();
        }

        if (result.size() == 0) {
            return 0;
        }
        
        int random = 0 + (int) (Math.random() * (result.size() + 1));
        int index = random < result.size() ? random : result.size() - 1;
        //
        return result.get(index).getNum();
    }
    
    private static List<Integer> getMargin2ToExclude(List<Lot> lots, int term, ColType type) {
        List<Integer> list = Lists.newArrayList();
        List<NumProbability> margin2Nums = PredictUtil.getPredictNextTerm(lots, 2, term, type).stream()
                .filter(it -> it.getProbability() > 0.).collect(Collectors.toList());
        List<Integer> tmp = margin2Nums.stream().map(it -> it.getNum()).collect(Collectors.toList());
        
        // 排除概率最小的两个
        if (tmp.size() > 2) {
            list.add(tmp.get(tmp.size() - 1));
            list.add(tmp.get(tmp.size() - 2));
        }
        
        Collections.sort(list);
        return list;
    }

    private static int getNum(List<Lot> lots, int term, List<Integer> list, ColType type) {
        List<Integer> margin2List = getMargin2ToExclude(lots, term, type);
        List<NumProbability> nums = PredictUtil.getPredictNextTerm(lots, term, type);
        int n01 = filter(nums, list, margin2List);
        return n01;
    }
    
    public static List<Integer> getCalResults(List<Lot> lots, int term) {
        List<Integer> list = Lists.newArrayList();
        while (true) {
            list = getCalResult(lots, term);
            if (list.size() < 7) {
                continue;
            } else {
                break;
            }
        }
        return list;
    }
    
    private static List<Integer> getCalResult(List<Lot> lots, int term) {
        List<ColType> fTypeList = Lists.newArrayList(ColType.F01, ColType.F02, ColType.F03, ColType.F04, ColType.F05);
        List<Integer> list = calResultByTypes(lots,  term, fTypeList);
        
        List<ColType> eTypeList = Lists.newArrayList(ColType.E01, ColType.E02);
        List<Integer> eList = calResultByTypes(lots,  term, eTypeList);

        Collections.sort(list);
        Collections.sort(eList);
        
        list.addAll(eList);
        return list;
    }
    
    private static List<Integer> calResultByTypes(List<Lot> lots, int term, List<ColType> types) {
        List<Integer> list = Lists.newArrayList();
        for (ColType type : types) {
            int n01 = getNum(lots, term, list, type);
            if (n01 == 0) {
                return list;
            } else {
                list.add(n01);
            }
        }
        return list;
    }
}
