package interview.cal;

import java.util.List;

import interview.SaleItem;

public interface CalStrategy {
	double collect(List<SaleItem> items);
}
