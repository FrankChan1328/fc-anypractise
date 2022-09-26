package lot.handle;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import lot.entity.Lot;
import lot.entity.NumProbability;

public class PredictUtil {
    
    // +=========================================================================================================
    public static void calEHitSeq(List<Lot> lots, int eIndex) {
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < lots.size() - 1; i++) {
            int hitSeq = getHitSeq(lots, lots.get(i).getTerm(), eIndex);
            list.add(hitSeq);
        }
        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(it -> it, Collectors.counting()));
        int total = map.values().stream().mapToInt(it->it.intValue()).sum();
        System.out.println(map);
        
        Map<Integer, Double> frequencyMap =Maps.newHashMap(); 
        map.forEach((k,v)->{
            frequencyMap.put(k, getPercentage(v.intValue(), total));
        });
        System.out.println(frequencyMap);
    }
    
    /**
     * 对于指定term，获取它是下次预测盖了排序队列中的第几个
     */
    public static int getHitSeq(List<Lot> lots, int term, int eIndex) {
        Lot lot = lots.stream().filter(it -> it.getTerm() == term).findFirst().get();
        NumProbability numPro = predictENextTerm(lots, term, eIndex).stream()
                .filter(it -> it.getNum() == lot.getE(eIndex)).findFirst().get();
        
        List<NumProbability> toSorts = numPro.getNextPros().stream()
                .sorted(Comparator.comparing(NumProbability::getProbability).reversed()).collect(Collectors.toList());

        int nextTerm = getNextTerm(lots, term);
        Lot nextLot = lots.stream().filter(it -> it.getTerm() == nextTerm).findFirst().get();

        for (int i = 1; i <= toSorts.size(); i++) {
            NumProbability num = toSorts.get(i-1);
            if(num.getNum() == nextLot.getE(eIndex)) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 获得指定term 的下一期
     */
    public static int getNextTerm(List<Lot> lots, int term) {
        int count = 0;
        for (int i = 0; i < lots.size(); i++) {
            if (lots.get(i).getTerm() == term) {
                count = i;
                break;
            }
        }
        int index = count < lots.size() ? count + 1 : count;
        return lots.get(index).getTerm();
    }
    
    /**
     * 判断重复出现的
     */
    public static void occurFrequency(List<Lot> lots) {
        Map<String, Long> map = lots.stream().collect(Collectors.groupingBy(Lot::getTotal, Collectors.counting()));
        List<Entry<String, Long>> list =  map.entrySet().stream().filter(it -> it.getValue() >1L).collect(Collectors.toList());
        List<Lot> results = lots.stream().filter(it -> it.getTotal().equals("05101931320910")).collect(Collectors.toList());
        System.out.println(results);
    }
    
    public static void printE(List<Lot> totalLots, int term, int eIndex) {
        Lot lot = totalLots.stream().filter(it -> it.getTerm() == term).findFirst().get();
        printPredict(totalLots, lot.getE(eIndex), eIndex, term);
    }
    
    public static void printPredict(List<Lot> totalLots, int e0x, int index, int term) {
        NumProbability numPro = predictENextTerm(totalLots, term, index).stream().filter(it -> it.getNum() == e0x)
                .findFirst().get();
        System.out.println("E0" + index + ":");
        numPro.getNextPros().stream().sorted(Comparator.comparing(NumProbability::getProbability).reversed()).forEach(it -> {
            System.out.println(it.getNum() + " " + it.getProbability() + "%");
        });
    }
    
    public static List<NumProbability> predictENextTerm(List<Lot> totalLots, int term, int eIndex) {
        List<Lot> lots = totalLots.stream().filter(it -> term > 0 && it.getTerm() <= term).collect(Collectors.toList());
        int total = lots.size();
        
        List<NumProbability> numPros = Lists.newArrayList();
        for (int i = 1; i <= 12; i++) {
            int num = i;
            Stream<Lot> streams = lots.stream().filter(it -> it.getE(eIndex) == num);
            List<Lot> target = streams.collect(Collectors.toList());
            //
            Double frequency = getPercentage(target.size(), total);
            NumProbability current = new NumProbability(num, frequency);
            numPros.add(current);
            
            List<NumProbability> nextPros = Lists.newArrayList();
            current.setNextPros(nextPros);

            // 下次出现数字
            for (int k = 1; k <= 12; k++) {
                int count = 0;
                int toCompare = k;
                
                for (int j = 0; j < total; j++) {
                    Lot lot = lots.get(j);
                    if (lot.getE(eIndex) == num) {
                        if (j < total - 1) {
                            if (lots.get(j + 1).getE(eIndex) == toCompare) {
                                count++;
                            }
                        }
                    }
                }
                
                Double frequency2 = getPercentage(count, target.size());
                nextPros.add(new NumProbability(k, frequency2));
            }
        }
        return numPros;
    }
    
    
    public static Double getPercentage(int times, int total) {
        if (total == 0) {
            return 0.;
        }
        return getPercentage(times * 1., total * 1.);
    }
    
    public static Double getPercentage(Double times, Double total) {
        BigDecimal progress = new BigDecimal(times / total * 100);
        return progress.setScale(4, BigDecimal.ROUND_UP).doubleValue();
    }
}
