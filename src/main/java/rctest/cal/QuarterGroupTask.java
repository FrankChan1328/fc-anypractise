package rctest.cal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rctest.SaleItem;

/**
 * 按季度对销售信息分组
 * <p> 根据月份计算得到季度值
 */
public class QuarterGroupTask extends BaseSaleItemGroupTask {
    
    public QuarterGroupTask(List<SaleItem> items) {
        super(items);
    }

    @Override
    public Map<Integer, List<SaleItem>> group() {
        List<SaleItem> items = getItems();
        Map<Integer, List<SaleItem>> map = new HashMap<>();
        if (null != items && !items.isEmpty()) {
            for (SaleItem item : items) {
                if (item.getMonth() > 0 && item.getMonth() <= 12) {
                    int quarter = (item.getMonth() - 1) / 3 + 1;
                    setKeySaleItems(map, item, quarter);
                }
            }
        }
        return map;
    }

}
