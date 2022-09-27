package lot2.pre;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import lot.entity.Lot;

public class BaseUtil {
    
    /**
     * 检查后区两个至少一个与前区都重复的概率
     */
    public static void checkERepeat2(List<Lot> lots) {
        List<Lot> repeat = lots.stream().filter(it -> it.eInF()).collect(Collectors.toList());
        Double perc = getPercentage(repeat.size(), lots.size());
        System.out.println(perc);
    }
    
    /**
     * 检查后区第一个与前区重复的概率
     */
    public static void checkERepeat01(List<Lot> lots) {
        List<Lot> repeat = lots.stream().filter(it -> it.e01InF()).collect(Collectors.toList());
        Double perc = getPercentage(repeat.size(), lots.size());
        System.out.println(perc);
    }
    
    /**
     * 检查后区第二个与前区重复的概率
     */
    public static void repeat02(List<Lot> lots) {
        List<Lot> repeat = lots.stream().filter(it -> it.e02InF()).collect(Collectors.toList());
        Double perc = getPercentage(repeat.size(), lots.size());
        System.out.println(perc);
    }
    
    /**
     * 重复性计算
     */
    public static void repeatBoth(List<Lot> lots) {
        List<Lot> repeat = lots.stream().filter(it -> it.e01InF() && it.e02InF()).collect(Collectors.toList());
        Double perc = getPercentage(repeat.size(), lots.size());
        System.out.println(perc);
    }

    
    /**
     * 本次重复，下次继续重复的概率
     */
    public static void repeatRepeat(List<Lot> lots) {
        int count = 0;
        for (int i = 0; i < lots.size() - 1; i++) {
            Lot current = lots.get(i);
            Lot next = lots.get(i + 1);
            if (current.eInF() && next.eInF()) {
                count++;
            }
        }
        Double perc = getPercentage(count, lots.size());
        System.out.println(perc);
    }
    
    /**
     * 本次重复，下次不重复的概率
     */
    public static void nonRepeatRepeat(List<Lot> lots) {
        int count = 0;
        for (int i = 0; i < lots.size() - 1; i++) {
            Lot current = lots.get(i);
            Lot next = lots.get(i + 1);
            if (!current.eInF() && next.eInF()) {
                count++;
            }
        }
        Double perc = getPercentage(count, lots.size());
        System.out.println(perc);
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
    
    public static int getNextTerm(List<Lot> lots, int margin, int term) {
        int count = 0;
        for (int i = 0; i < lots.size(); i++) {
            if (lots.get(i).getTerm() == term) {
                count = i;
                break;
            }
        }
        int index = count < lots.size() - margin ? count + margin : count;
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
