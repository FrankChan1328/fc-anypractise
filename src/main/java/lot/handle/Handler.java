package lot.handle;

import java.util.Comparator;
import java.util.List;
import lott.entity.Lot;
import lot.util.LotUtil;

public class Handler {
    
    public static void main(String[] args) throws Exception {
        List<Lot> lots = getLots();
        int term = 22110;
        
        
//        PredictBase.nonRepeatRepeat(lots);
        
        
//        predictE(lots, term);
        
        predictAll(lots, term);
        
        PredictOldUtil.printOldPredict(lots, term, term, term);
        
//        testAll(lots, term);
    }
    
    public static void predictE(List<Lot> lots, int term) {
        PredictUtil.printE(lots, term, 1);
        PredictUtil.printE(lots, term, 2);
    }
    
    public static void predictAll(List<Lot> lots, int term) {
        List<Integer> results = CalTotal.getCalResults(lots, term);
        System.out.println(results);
    }
    
    public static void testAll(List<Lot> lots, int term) {
        int nextTerm = PredictBase.getNextTerm(lots, term);
        Lot nextLot = lots.stream().filter(it -> it.getTerm() == nextTerm).findFirst().get();
        
        int count = 0;
        while (true) {
            count ++;
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
            
            if(count < 0) {
                
            }
            if(lot.getE01() == nextLot.getE01()) {
                
            }
            
            if(lot.getE01() == nextLot.getE01() && lot.getE02() == nextLot.getE02()) {
                System.out.println("here12");
            }
            
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
