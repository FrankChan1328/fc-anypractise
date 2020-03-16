package rctest.cal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import rctest.QuarterSalesItem;
import rctest.SaleItem;

/**
 * 基础的计算任务
 */
public abstract class CalculateBaseTask {

    /**
     * 求每个统计粒度下的销售额计算处理结果集合
     * @param itemsMap 统计粒度下销售信息的map
     * @return
     */
    public List<QuarterSalesItem> calculate(Map<Integer, List<SaleItem>> itemsMap) {
        if (null == itemsMap || itemsMap.isEmpty()) {
            return null;
        }

        List<QuarterSalesItem> metrics = new ArrayList<>();
        Iterator<Entry<Integer, List<SaleItem>>> iter = itemsMap.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<Integer, List<SaleItem>> entry = iter.next();
            QuarterSalesItem item = doSpecificCal(entry.getKey(), entry.getValue());
            if (item != null) {
                metrics.add(item);
            }
        }
        return metrics;
    }

    /**
     * 做具体的计算,比如求和，求最大值等
     * @param metrics
     * @param key
     * @param items
     */
    protected abstract QuarterSalesItem doSpecificCal(Integer key, List<SaleItem> items);
}
