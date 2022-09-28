package lott.multi.entry;

import java.util.List;

import lott.entity.Lot;

public class LotContext {
    /**
     * 所有lot 数据
     */
    private List<Lot> lots;
    
    public LotContext(List<Lot> lots) {
        this.lots = lots;
    }

    public List<Lot> getLots() {
        return lots;
    }

    public void setLots(List<Lot> lots) {
        this.lots = lots;
    }
}
