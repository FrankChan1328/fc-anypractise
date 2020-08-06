package interview.cal;

import static java.util.stream.Collectors.groupingBy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;

import interview.QuarterSalesItem;
import interview.SaleItem;

public class CalStrategy {
    protected List<SaleItem> saleItems;
    private Function<SaleItem, Integer> groupFunction;
    private Collector calCollector;

    public CalStrategy(List<SaleItem> saleItems, Collector calCollector) {
        this.saleItems = saleItems;
        this.groupFunction = getDefaultGroupFunction();
        this.calCollector = calCollector;
    }

    public CalStrategy(List<SaleItem> saleItems, Function<SaleItem, Integer> groupFunction, Collector calCollector) {
        this.saleItems = saleItems;
        this.groupFunction = groupFunction;
        this.calCollector = calCollector;
    }

    public List<QuarterSalesItem> cal() {
        List<QuarterSalesItem> result = new ArrayList<>();
        if (null != saleItems && saleItems.size() > 0) {
            Map<Integer, List<SaleItem>> map = saleItems.stream().collect(groupingBy(groupFunction));

            map.forEach((k, v) -> {
                double value = (double) v.stream().collect(calCollector);
                result.add(getQuarterSalesItem(k, value));
            });
        }
        return result;
    }

    /**
     * 取按季度分组为默认分组
     */
    private Function<SaleItem, Integer> getDefaultGroupFunction() {
        Function<SaleItem, Integer> function = item -> {
            return (item.getMonth() - 1) / 3 + 1;
        };
        return function;
    }

    private QuarterSalesItem getQuarterSalesItem(int quater, double value) {
        QuarterSalesItem qsi = new QuarterSalesItem();
        qsi.setQuarter(quater);
        qsi.setValue(value);
        return qsi;
    }
}
