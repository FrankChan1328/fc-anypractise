package lot.handle;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import lot.entity.Lot;

public class PredictUtil {
    
    /**
     * 后区出现数字之后，下次出现数字的概率统计
     */
    public static void predictE01NextTerm(List<Lot> totalLots, int term) {
        List<Lot> lots = totalLots.stream().filter(it -> term > 0 && it.getTerm() <= term).collect(Collectors.toList());
        int total = lots.size();
        
        for (int i = 1; i <= 12; i++) {
            int num = i;
            List<Lot> target = lots.stream().filter(it -> it.getE01() == num).collect(Collectors.toList());
            // 总共出现频率
            Double frequency = getPercentage(target.size(), total);
            System.out.println("当前数字：" + i + ":" + frequency);
            // 下次出现数字
            for (int k = 1; k <= 12; k++) {
                int count = 0;
                int toCompare = k;
                
                for (int j = 0; j < total; j++) {
                    Lot lot = lots.get(j);
                    if (lot.getE01() == num) {
                        if (j < total - 1) {
                            if (lots.get(j + 1).getE01() == toCompare) {
                                count++;
                            }
                        }
                    }
                }
                
                Double frequency2 = getPercentage(count, target.size());
                System.out.println("下期同位置数字：" + k + " 出现概率:" + frequency2);
            }
        }
    }
    
    /**
     * 后区02出现数字之后，下次后区02出现数字的概率统计
     */
    public static void predictE02NextTerm(List<Lot> totalLots, int term) {
        List<Lot> lots = totalLots.stream().filter(it -> term > 0 && it.getTerm() <= term).collect(Collectors.toList());
        int total = lots.size();
        
        for (int i = 1; i <= 12; i++) {
            int num = i;
            List<Lot> target = lots.stream().filter(it -> it.getE02() == num).collect(Collectors.toList());
            // 总共出现频率
            Double frequency = getPercentage(target.size(), total);
            System.out.println("当前数字：" + i + ":" + frequency);
            // 下次出现数字
            for (int k = 1; k <= 12; k++) {
                int count = 0;
                int toCompare = k;
                
                for (int j = 0; j < total; j++) {
                    Lot lot = lots.get(j);
                    if (lot.getE02() == num) {
                        if (j < total - 1) {
                            if (lots.get(j + 1).getE02() == toCompare) {
                                count++;
                            }
                        }
                    }
                }
                
                Double frequency2 = getPercentage(count, target.size());
                System.out.println("下期同位置数字：" + k + " 出现概率:" + frequency2);
            }
        }
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
