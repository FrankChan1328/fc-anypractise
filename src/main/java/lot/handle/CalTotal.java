package lot.handle;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import lot.entity.Lot;
import lot.entity.NumProbability;

public class CalTotal {
    public static List<Integer> getCalResults(List<Lot> lots, int term) {
        List<Integer> list = Lists.newArrayList();
        while(true) {
            list = Lists.newArrayList();
            // 前区
            List<NumProbability> f01 = PredictFUtil.predictFNextTerm(lots, term, 1);
            int n01 = filter(f01, list);
            list.add(n01);
            
            List<NumProbability> f02 = PredictFUtil.predictFNextTerm(lots, term, 2);
            list.add(filter(f02, list));
            List<NumProbability> f03 = PredictFUtil.predictFNextTerm(lots, term, 3);
            int n03 = filter(f03, list);
            if(n03 ==0) {
                continue;
            }
            list.add(n03);
            
            List<NumProbability> f04 = PredictFUtil.predictFNextTerm(lots, term, 4);
            int n04 = filter(f04, list);
            if(n04 ==0) {
                continue;
            }
            list.add(n04);
            
            List<NumProbability> f05 = PredictFUtil.predictFNextTerm(lots, term, 4);
            int n05 = filter(f05, list);
            if(n05 ==0) {
                continue;
            }
            list.add(n05);
            
            List<Integer> list2 = Lists.newArrayList();
            // 后区
            List<NumProbability> e01 = PredictUtil.predictENextTerm(lots, term, 1);
            int ne01 = filter(e01, list2);
            if(ne01 ==0) {
                continue;
            }
            list2.add(ne01);
            List<NumProbability> e02 = PredictUtil.predictENextTerm(lots, term, 2);
            int ne02 = filter(e02, list2);
            if(ne02 ==0) {
                continue;
            }
            list2.add(ne02);

            list.addAll(list2);
            break;
        }
//        System.out.println(list);
        return list;
    }

    private static int filter(List<NumProbability> sourceNums, List<Integer> list) {
        int size = sourceNums.size();
        int max = list.size() == 0 ? 0 : list.get(list.size() - 1);
        List<NumProbability> nums = sourceNums.size() > 4 ? sourceNums.subList(0, size - 2) : sourceNums;

        List<NumProbability> result = nums.stream().filter(it -> it.getProbability() > 0.)
                .filter(it -> !list.contains(it.getNum()) && it.getNum() > max).collect(Collectors.toList());

        if(result.size() == 1) {
            return result.get(0).getNum();
        }
        
        if(result.size() == 0) {
            return 0;
        }
        
        int random = 0 + (int) (Math.random() * (result.size() + 1));
        int index = random < result.size() ? random : result.size() - 1;
        //
        return result.get(index).getNum();
    }
}
