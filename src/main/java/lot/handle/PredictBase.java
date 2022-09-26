package lot.handle;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import lot.entity.Lot;

public class PredictBase {
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
