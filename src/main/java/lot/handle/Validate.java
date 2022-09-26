package lot.handle;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import java8.sw.ObjectEntity;
import lot.entity.Lot;
import lot.util.LotUtil;

public class Validate {

    public static void main(String[] args) throws Exception {
//        String path = "E:/data.xlsx";
        String path = "E:\\dev\\fc-anypractise\\src\\main\\resources\\lot\\data.xlsx";
        List<Lot> lots = LotUtil.convert(path);
        // 按期数排序
        lots.sort(Comparator.comparing(Lot::getTerm));
        int num = 10;
        int toValidate = 8;
        int total = lots.size();
        
        
        for (int i = 0; i < total; i++) {
            Lot lot = lots.get(i);
            if(lot.getE01() == num) {
                if(i < total -1) {
                    Lot lot2 = lots.get(i +1);
                    if(lot2.getE01() == toValidate) {
                        System.out.println("here");
                    }
                }
            }
            
        }
    }
    
    public static void occurFrequency(List<Lot> lots) {
        Map<String, Long> map = lots.stream().collect(Collectors.groupingBy(Lot::getTotal, Collectors.counting()));
        List<Entry<String, Long>> list =  map.entrySet().stream().filter(it -> it.getValue() >1L).collect(Collectors.toList());
        List<Lot> results = lots.stream().filter(it -> it.getTotal().equals("05101931320910")).collect(Collectors.toList());
    }
    
    /**
     * 后区出现数字之后，下次出现数字的概率统计
     */
    public static void predictE01NextTerm(List<Lot> lots) {
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
