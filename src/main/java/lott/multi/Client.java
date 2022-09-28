package lott.multi;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import lot2.pre.BaseUtil;
import lot2.pre.PredictUtil;
import lott.entity.ColType;
import lott.entity.Lot;
import lott.entity.NumProbability;
import lott.multi.cal.CalCulate;
import lott.multi.cal.LotCal;
import lott.multi.entry.LotEntry;
import lott.util.PossibilityUtil;
import lott.util.WeightRandomUtil;

public class Client {

    public static void main(String[] args) throws Exception {
        LotEntry entry = CalCulate.getEntry();

        List<Lot> total = entry.getContext().getLots();
        int count = 0;
        int count2 = 0;
        for (int i = total.size() - 2; i > 1000; i--) {
            int times = testMatch(total.get(i).getTerm(), entry);
            count += times;
            if(times != 400) {
                count2 += times;
            }
        }

        System.out.println(BaseUtil.getPercentage(count, total.size() - 502));
        System.out.println(BaseUtil.getPercentage(count2, total.size() - 502));
    }

    private static int testMatch(int term, LotEntry entry) {
        LotCal cal = new LotCal(term, entry);
        
        // current term
        Lot nextLot = cal.getNext();

        int count = 0;
        while (true) {
            count++;

            List<NumProbability> e01Results = PossibilityUtil.calNumPosibility(cal.getLots(), ColType.E01);
            int e01 = filter(e01Results, Lists.newArrayList());
            
            int beforeTerm = cal.getBefore().getTerm();
            List<Integer> before01Results = PossibilityUtil.calNumPosibility(cal.getLots(), ColType.E01);

            List<NumProbability> e02Results = PossibilityUtil.calNumPosibility(cal.getLots(), ColType.E02);
            int e02 = filter(e02Results, Lists.newArrayList(e01));

            if (nextLot.getE01() == e01 && nextLot.getE02() == e02) {
                System.out.println(count);
                return count;
            }
            
            if(count == 300) {
//                System.out.println("终止！！！");
                return 400;
            }
        }
    }
    
    
    /**
     * 过滤数据：
     * <br>1.排除概率最低的两个数据
     * <del>2.排除概率最高的一个数据(不排除)</del>
     */
    private static int filter(List<NumProbability> sourceNums, List<Integer> list) {
        List<NumProbability> nums = sourceNums.size() > 2 ? sourceNums.subList(0, sourceNums.size() - 2) : sourceNums;

        List<NumProbability> result = nums.stream().filter(it -> it.getProbability() > 0.)
                .filter(it -> !list.contains(it.getNum()))
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
}
