package rctest.cal;

import java.util.List;

import rctest.QuarterSalesItem;
import rctest.SaleItem;

/**
 * 销售信息分组求和
 */
public class CalculateSumTask extends CalculateBaseTask{

    @Override
    protected QuarterSalesItem doSpecificCal(Integer key, List<SaleItem> items) {
        double sum = 0;
        for (SaleItem item : items) {
            sum += item.getSaleNumbers();
        }
        return new QuarterSalesItem(key, sum);
    }

}
