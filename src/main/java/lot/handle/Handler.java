package lot.handle;

import java.util.Comparator;
import java.util.List;
import lot.entity.Lot;
import lot.util.LotUtil;

public class Handler {
    
    public static void main(String[] args) throws Exception {
        List<Lot> lots = getLots();
        
        
        
        PredictUtil.calEHitSeq(lots, 1);
        
        

//        int term = 22108;
//
////        PredictUtil.printE(lots,term,  2);
////        PredictUtil.foo(lots, 2);
//        
//        PredictUtil.printE(lots,term, 1);
//        System.out.println("");
//        int result = PredictUtil.getHitSeq(lots, term, 1);
//        System.out.println(result);
    }
    
    public static List<Lot> getLots() throws Exception{
        String path = "E:\\dev\\fc-anypractise\\src\\main\\resources\\lot\\data.xlsx";
        List<Lot> lots = LotUtil.convert(path);
        // 按期数排序
        lots.sort(Comparator.comparing(Lot::getTerm));
        return lots;
    }
}
