package lot2;

import java.util.Comparator;
import java.util.List;

import lott.base.LotUtil;
import lott.entity.Lot;
import lott.entity.NumProbability;
import lot2.pre.CalTotal;
import lot2.pre.PossibilityUtil;

public class Client {

    public static void main(String[] args) throws Exception {
        List<Lot> lots = getLots();
        
//        PredictUtil.printPosibility(lots, 2, ColType.E01);
        
//        PredictUtil.getHitSeq(lots, 22109, ColType.E01);
        
//        int seq = PredictUtil.getHitSeq(lots, 22108, 2, ColType.E01);
//        System.out.println(seq);
        
//        testAll(lots, 22107);
//        List<NumProbability> result = PossibilityUtil.calEMarginPosibility(lots);
//        result.forEach(it ->{
//            System.out.println(it.getNum()+" "+ it.getProbability());
//        });
        
        CalTotal.foo(lots);
//        int result = CalTotal.targetAll(lots, 22107);
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
