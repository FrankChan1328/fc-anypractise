package rctest.cal;

import java.util.List;

import rctest.QuarterSalesItem;
import rctest.SaleItem;

/**
 * 销售信息分组求最大值
 */
public class CalculateMaxTask extends CalculateBaseTask {

    @Override
    protected QuarterSalesItem doSpecificCal(Integer key, List<SaleItem> items) {
        double max = 0;
        for (SaleItem item : items) {
            max = Math.max(max, item.getSaleNumbers());
        }
        return new QuarterSalesItem(key, max);
    }
}
