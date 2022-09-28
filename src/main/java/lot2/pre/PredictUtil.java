package lot2.pre;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lott.entity.Lot;
import lott.entity.NumProbability;
import lott.entity.ColType;

public class PredictUtil {
    
    public static int getHitSeq(List<Lot> totalLots, int term, ColType type) {
        return getHitSeq(totalLots, term, 1, type);
    }
    
    /**
     * 对于指定term，获取它是下次预测的排序队列中的第几个
     */
    public static int getHitSeq(List<Lot> totalLots , int term, int margin, ColType type) {
        List<Lot> lots = totalLots.stream().filter(it -> {
            return term <= 0 || (term > 0 && it.getTerm() <= term);
        }).collect(Collectors.toList());
        
        Lot lot = lots.stream().filter(it -> it.getTerm() == term).findFirst().get();
        int currentTypeNum = lot.get(type);
        
        // 获取所有的
        List<NumProbability> results = PossibilityUtil.calNumPosibility(lots, margin, type);
        NumProbability numPro = results.stream().filter(it -> it.getNum() == currentTypeNum).findFirst().get();
        
        int nextTerm = BaseUtil.getNextTerm(totalLots, margin, term);
        Lot nextLot = totalLots.stream().filter(it -> it.getTerm() == nextTerm).findFirst().get();

        for (int i = 1; i <= numPro.getNextPros().size(); i++) {
            NumProbability num = numPro.getNextPros().get(i - 1);
            if (num.getNum() == nextLot.get(type)) {
                return i;
            }
        }
        return 0;
    }
    
    // *******************************************
    public static List<NumProbability> getPredictNextTerm(List<Lot> totalLots, int term, ColType type) {
        return getPredictNextTerm(totalLots, 1, term, type);
    }
    
    /**
     * 精准寻找某个数字之后的预期
     */
    public static List<NumProbability> getPredictNextTerm(List<Lot> totalLots, int margin, int term, ColType type) {
        Lot lot = totalLots.stream().filter(it -> it.getTerm() == term).findFirst().get();

        List<Lot> lots = totalLots.stream().filter(it -> {
            return term <= 0 || (term > 0 && it.getTerm() <= term);
        }).collect(Collectors.toList());

        int currentTypeNum = lot.get(type);
        // 获取所有的
        List<NumProbability> results = PossibilityUtil.calNumPosibility(lots, margin, type);
        NumProbability numPro = results.stream().filter(it -> it.getNum() == currentTypeNum).findFirst().get();
        return numPro.getNextPros();
    }
    
    // ************************************************************************
    
    public static void printPosibility(List<Lot> totalLots, ColType type) {
        printPosibility(totalLots, 1, type, 0);
    }

    public static void printPosibility(List<Lot> totalLots, int margin, ColType type) {
        printPosibility(totalLots, margin, type, 0);
    }

    public static void printPosibility(List<Lot> totalLots, ColType type, int term) {
        printPosibility(totalLots, 1, type, term);
    }

    /**
     * 打印某期之前的数字概率
     * 
     * @param totalLots
     * @param type
     * @param term      为0 或者负，则为所有
     */
    public static void printPosibility(List<Lot> totalLots, int margin, ColType type, int term) {
        List<Lot> lots = totalLots.stream().filter(it -> {
            return term <=0 || ( term > 0 && it.getTerm() <= term);
        }).collect(Collectors.toList());
        List<NumProbability> results = PossibilityUtil.calNumPosibility(lots, margin, type);
        
        for (NumProbability num : results) {
            System.out.println(type.name() + " 当前数字：" + num.getNum() + ", 下 [" + margin + "] 次数字出现概率：");
            num.getNextPros().stream().sorted(Comparator.comparing(NumProbability::getProbability).reversed()).forEach(it -> {
                System.out.println(it.getNum() + " " + it.getProbability() + "%");
            });
        }
    }
}
