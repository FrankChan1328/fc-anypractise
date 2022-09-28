package lott.multi.entry;

import java.util.List;

import lott.entity.NumProbability;

/**
 * 基本运算数据
 */
public class LotBasicCal {
    /**
     * 后两个数值的差值分布
     */
    private List<NumProbability> eMarginDist;
    
    
    public LotBasicCal(List<NumProbability> eMarginDist) {
        this.eMarginDist = eMarginDist;
    }

    public List<NumProbability> geteMarginDist() {
        return eMarginDist;
    }

    public void seteMarginDist(List<NumProbability> eMarginDist) {
        this.eMarginDist = eMarginDist;
    }
}
