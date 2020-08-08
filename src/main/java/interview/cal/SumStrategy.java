package interview.cal;

import static java.util.stream.Collectors.summingDouble;

import java.util.List;
import java.util.stream.Collector;

import interview.SaleItem;

public class SumStrategy implements CalStrategy {

	@Override
	public double collect(List<SaleItem> items) {
		Collector<SaleItem, ?, Double> sumCollector = summingDouble(SaleItem::getSaleNumbers);
		return items.stream().collect(sumCollector);
	}
}
