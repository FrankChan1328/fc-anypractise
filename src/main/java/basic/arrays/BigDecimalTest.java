package basic.arrays;

import java.math.BigDecimal;

public class BigDecimalTest {

	public static void main(String[] args) {
		BigDecimal bigDecimal1 = new BigDecimal(1);
		BigDecimal bigDecimal2 = new BigDecimal(1);
		System.out.println(bigDecimal1.equals(bigDecimal2));
		
		BigDecimal bigDecimal3 = new BigDecimal(1);
		BigDecimal bigDecimal4 = new BigDecimal(1.0);
		System.out.println(bigDecimal3.equals(bigDecimal4));
		
		BigDecimal bigDecimal5 = new BigDecimal("1");
		BigDecimal bigDecimal6 = new BigDecimal("1.0");
		System.out.println(bigDecimal5.equals(bigDecimal6));
	}
}
