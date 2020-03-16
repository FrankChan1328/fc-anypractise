package rctest.cal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import rctest.SaleItem;

/**
 * 销售条目统计分组基础接口
 */
public abstract class BaseSaleItemGroupTask {
    
    private List<SaleItem> items;
    
    protected BaseSaleItemGroupTask(List<SaleItem> items){
        this.items = items;
    }

    /**
     * 对待统计条目做分组
     * @param items
     * @return 返回 key --> List 类型的映射关系
     */
    public abstract Map<Integer, List<SaleItem>> group();
    
    /**
     * 根据map key 设置销售信息
     * @param map 销售信息按具体粒度(年、季度等)汇总的map
     * @param item 具体
     * @param key 销售信息汇总的key，可以是年，可以是季度，可以是月份
     */
    public void setKeySaleItems(Map<Integer, List<SaleItem>> map, SaleItem item,
            Integer key) {
        if (null != key) {
            List<SaleItem> items = map.get(key);
            if (null == items) {
                items = new ArrayList<>();
                map.put(key, items);
            }
            items.add(item);
        }
    }

    public List<SaleItem> getItems() {
        return items;
    }
}
