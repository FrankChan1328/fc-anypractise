package interview.cal;

import java.util.List;

import interview.SaleItem;

public class MaxStrategy implements CalStrategy {

	@Override
	public double collect(List<SaleItem> items) {
		double max = 0;
		for (SaleItem item : items) {
			max = Math.max(max, item.getSaleNumbers());
		}
		return max;
	}
}
