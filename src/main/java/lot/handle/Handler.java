package lot.handle;

import java.util.Comparator;
import java.util.List;
import lot.entity.Lot;
import lot.util.LotUtil;

public class Handler {
    
    public static void main(String[] args) throws Exception {
        List<Lot> lots = getLots();
//        int term = 22102;
//        PredictFUtil.printF(lots, term, 5);
        
        PredictFUtil.calEHitSeq(lots, 1);
    }
    
    public static List<Lot> getLots() throws Exception{
        String path = "E:\\dev\\fc-anypractise\\src\\main\\resources\\lot\\data.xlsx";
        List<Lot> lots = LotUtil.convert(path);
        // 按期数排序
        lots.sort(Comparator.comparing(Lot::getTerm));
        return lots;
    }
}
