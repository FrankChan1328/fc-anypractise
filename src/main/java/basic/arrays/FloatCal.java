package basic.arrays;

import java.math.BigDecimal;

public class FloatCal {

	public static void main(String[] args) {
//		System.out.println(0.05 + 0.01);
//		System.out.println(1.0 - 0.42);
//		System.out.println(4.015 * 100);
//		System.out.println(123.3 / 100);
		
		BigDecimal a = new BigDecimal(1.01);
		BigDecimal b = new BigDecimal(1.02);
		System.out.println(a);
		BigDecimal c = new BigDecimal("1.01");
		BigDecimal d = new BigDecimal("1.02");
		System.out.println(a.add(b));
		System.out.println(c.add(d));
	}
}
