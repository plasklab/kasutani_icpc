class Stack {
	private final int MAX = 200;
	private String[] stack;
	private int top;

	Stack() {
		stack = new String[MAX];
		top = 0;
	}

	void push(String x) {
		if (isFull()) {
			System.out.println("Stack is full");
			return;
		}
		top++;
		stack[top] = x;
	}

	String pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		top--;
		return stack[top + 1];
	}

	void initialize() {
		top = 0;
	}

	boolean isEmpty() {
		if(top == 0) return true;
		return false;
	}

	boolean isFull() {
		if(top >= MAX - 1) return true;
		return false;
	}
}