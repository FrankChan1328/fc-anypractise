package lot.handle;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import lot.entity.Lot;
import lot.entity.NumProbability;
import lot.util.LotUtil;

public class Handler {
    
    public static void main(String[] args) throws Exception {
        List<Lot> lots = getLots();
        int term = 22107;
//        PredictFUtil.printF(lots, term, 5);
//        CalTotal.getCalResults(lots, term1);
        testAll(lots, term);
//        
//        List<Lot> temp = lots.stream().filter(it -> it.getF01() == 30).collect(Collectors.toList());
//        System.out.print(temp);
//        
//        PredictFUtil.calEHitSeq(lots, 1);
    }
    
    
    public static void testAll(List<Lot> lots, int term) {
        int nextTerm = PredictBase.getNextTerm(lots, term);
        Lot nextLot = lots.stream().filter(it -> it.getTerm() == nextTerm).findFirst().get();
        while (true) {
            List<Integer> results = CalTotal.getCalResults(lots, term);
            Lot lot = new Lot();
            lot.setF01(results.get(0));
            lot.setF02(results.get(1));
            lot.setF03(results.get(2));
            lot.setF04(results.get(3));
            lot.setF05(results.get(4));
            lot.setE01(results.get(5));
            lot.setE02(results.get(6));
            lot.setTotal(LotUtil.getTotal(lot));
//            if(lot.getE01() == nextLot.getE01() && lot.getE02() == nextLot.getE02()) {
//                System.out.println("here1");
//            }
            
            if(lot.getTotal().equals(nextLot.getTotal())) {
                System.out.println("here");
            }
        }
    }
    
    public static List<Lot> getLots() throws Exception{
        String path = "E:\\dev\\fc-anypractise\\src\\main\\resources\\lot\\data.xlsx";
        List<Lot> lots = LotUtil.convert(path);
        // 按期数排序
        lots.sort(Comparator.comparing(Lot::getTerm));
        return lots;
    }
}
