package design.other.reduceif;

public class IfClass {

	public static void main(String[] args) {
		
	}

	public int calculate(int a, int b, String action) {
		if ("ADD".equals(action)) {
			return a + b;
		}

		if ("MUL".equals(action)) {
			return a * b;
		}

		if ("DIV".equals(action)) {
			return a / b;
		}

		if ("SUB".equals(action)) {
			return a - b;
		}

		throw new RuntimeException("action unknown");
	}
}
