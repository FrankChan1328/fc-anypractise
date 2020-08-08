package interview.cal;

import static java.util.stream.Collectors.groupingBy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import interview.QuarterSalesItem;
import interview.SaleItem;

public class SalesContext {
	protected List<SaleItem> saleItems;
	private Function<SaleItem, Integer> groupFunction;
	private CalStrategy strategy;

	public SalesContext(List<SaleItem> saleItems, CalStrategy strategy) {
		this.saleItems = saleItems;
		this.groupFunction = getDefaultGroupFunction();
		this.strategy = strategy;
	}

	public SalesContext(List<SaleItem> saleItems, Function<SaleItem, Integer> groupFunction, CalStrategy strategy) {
		this.saleItems = saleItems;
		this.groupFunction = groupFunction;
		this.strategy = strategy;
	}

	public List<QuarterSalesItem> cal() {
		List<QuarterSalesItem> result = new ArrayList<>();
		if (null != saleItems && saleItems.size() > 0) {
			Map<Integer, List<SaleItem>> map = saleItems.stream().collect(groupingBy(groupFunction));
			map.forEach((k, v) -> {
				double value = strategy.collect(v);
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
