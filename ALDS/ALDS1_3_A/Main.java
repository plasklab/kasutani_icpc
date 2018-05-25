import java.util.*;

class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		Stack stack = new Stack();
		while(scan.hasNext()) {
			String s = scan.next();
			stack.push(s);
			if(s.equals("+") || s.equals("-") ||
				s.equals("*") || s.equals("/")) {
				stack.push(calculate(stack.pop(),
					Integer.parseInt(stack.pop()),
					Integer.parseInt(stack.pop())));
			}
		}
		System.out.println(stack.pop());
	}

	String calculate(String operand, int b, int a) {
		int ans = 0;
		switch(operand) {
		case "+":
			ans = a + b;
			// System.out.println(ans + " = " + a + " + " + b);
			break;
		case "-":
			ans = a - b;
			// System.out.println(ans + " = " + a + " - " + b);
			break;
		case "*":
			ans = a * b;
			// System.out.println(ans + " = " + a + " * " + b);
			break;
		case "/":
			ans = a / b;
			// System.out.println(ans + " = " + a + " / " + b);
			break;
		}
		return String.valueOf(ans);
	}
}