package lott.multi.cal;

import java.util.List;
import lott.base.LotUtil;
import lott.entity.Lot;
import lott.entity.NumProbability;
import lott.multi.entry.LotBasicCal;
import lott.multi.entry.LotContext;
import lott.multi.entry.LotEntry;
import lott.util.PossibilityUtil;

public class CalCulate {
    
    public static LotEntry getEntry() throws Exception {
        List<Lot> lots = LotUtil.getLots();
        //
        LotContext context = new LotContext(lots);

        List<NumProbability> eMarginDist = PossibilityUtil.eMarginDist(lots);
        LotBasicCal basicCal = new LotBasicCal(eMarginDist);

        LotEntry entry = new LotEntry(context, basicCal);
        return entry;
    }
}
