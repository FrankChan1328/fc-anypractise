package lot2.pre;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import lott.entity.Lot;
import lott.entity.NumProbability;
import lott.util.WeightRandomUtil;
import lott.base.LotUtil;
import lott.entity.ColType;

public class CalTotal {

    public static void foo(List<Lot> lots) {
        for (int i = lots.size() - 2; i > 500; i--) {
            Lot lot = lots.get(i);
            int result = targetAll(lots, lot.getTerm());
            System.out.println(lot.getTerm() + " " + result);
        }
    }
    
    public static int targetAll(List<Lot> lots, int term) {
        int nextTerm = BaseUtil.getNextTerm(lots, term);
        Lot nextLot = lots.stream().filter(it -> it.getTerm() == nextTerm).findFirst().get();
        int count = 0;
        
        while (true) {
            count ++;
            
            if(count == 500) {
                System.out.println("尝试了500 次");
                return 500;
            }
            
            List<Integer> results = CalTotal.getCalResults(lots, term);
            
            Lot lot = convert2Lot(results); 
            if(lot.getE01() == nextLot.getE01() && lot.getE02() == nextLot.getE02()) {
                System.out.println(lot.getTotal());
                return count;
            }
            
            if(lot.getTotal().equals(nextLot.getTotal())) {
                System.out.println("here");
            }
        }
    }
    
    /**
     * 过滤数据：
     * <br>1.排除概率最低的两个数据
     * <del>2.排除概率最高的一个数据(不排除)</del>
     */
    private static int filter(List<NumProbability> sourceNums, List<Integer> list,
            List<Integer> margin2List) {
        List<NumProbability> nums = sourceNums.size() > 2 ? sourceNums.subList(0, sourceNums.size() - 2) : sourceNums;
        
        List<NumProbability> result = nums.stream().filter(it -> it.getProbability() > 0.)
                .filter(it -> !list.contains(it.getNum()))
                .filter(it -> !margin2List.contains(it.getNum()))
                .collect(Collectors.toList());

        if (result.size() == 1) {
            return result.get(0).getNum();
        }

        if (result.size() == 0) {
            return 0;
        }
        
        return WeightRandomUtil.getNum(result);
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
        List<ColType> eTypeList = Lists.newArrayList(ColType.E01, ColType.E02);
        List<Integer> eList = calResultByTypes(lots, term, eTypeList, Lists.newArrayList());
        List<Integer> f2Exclude = WeightRandomUtil.get2ExcludeNums(eList);
        
        List<ColType> fTypeList = Lists.newArrayList(ColType.F01, ColType.F02, ColType.F03, ColType.F04, ColType.F05);
        List<Integer> list = calResultByTypes(lots, term, fTypeList, f2Exclude);

        Collections.sort(list);
        Collections.sort(eList);

        list.addAll(eList);
        return list;
    }
    
    private static List<Integer> calResultByTypes(List<Lot> lots, int term, List<ColType> types,
            List<Integer> f2Exclude) {
        List<Integer> list = Lists.newArrayList();
        for (ColType type : types) {
            int n01 = getNum(lots, term, list, type, f2Exclude);
            if (n01 == 0) {
                return list;
            } else {
                list.add(n01);
            }
        }
        return list;
    }

    private static int getNum(List<Lot> lots, int term, List<Integer> list, ColType type, List<Integer> f2Exclude) {
        int beforeTerm = BaseUtil.getBeforeTerm(lots, 1, term);
        List<Integer> margin2List = getMargin2ToExclude(lots, beforeTerm, type);
        // 概率计算
        margin2List.addAll(f2Exclude);

        List<NumProbability> nums = PredictUtil.getPredictNextTerm(lots, term, type);
        int n01 = filter(nums, list, margin2List);
        return n01;
    }
    
    public static Lot convert2Lot(List<Integer> results) {
        Lot lot = new Lot();
        lot.setF01(results.get(0));
        lot.setF02(results.get(1));
        lot.setF03(results.get(2));
        lot.setF04(results.get(3));
        lot.setF05(results.get(4));
        lot.setE01(results.get(5));
        lot.setE02(results.get(6));
        lot.setTotal(LotUtil.getTotal(lot));
        return lot;
    }
}
