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

public class Handler {

    public static void main(String[] args) throws Exception {
//        String path = "E:/data.xlsx";
        String path = "E:\\dev\\fc-anypractise\\src\\main\\resources\\lot\\data.xlsx";
        List<Lot> lots = LotUtil.convert(path);
        // 按期数排序
        lots.sort(Comparator.comparing(Lot::getTerm));
        
        System.out.println(lots);
        
        occurFrequency(lots);
        
        int term = 21001;
        PredictUtil.predictE02NextTerm(lots, term);
    }
    
    public static void occurFrequency(List<Lot> lots) {
        Map<String, Long> map = lots.stream().collect(Collectors.groupingBy(Lot::getTotal, Collectors.counting()));
        List<Entry<String, Long>> list =  map.entrySet().stream().filter(it -> it.getValue() >1L).collect(Collectors.toList());
        List<Lot> results = lots.stream().filter(it -> it.getTotal().equals("05101931320910")).collect(Collectors.toList());
//        System.out.println(list);
//        System.out.println(results);
    }
}
