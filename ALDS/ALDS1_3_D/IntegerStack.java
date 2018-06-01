class IntegerStack {
	private final int MAX = 20000;
	private int[] stack;
	private int top;
	private int count;

	IntegerStack() {
		stack = new int[MAX];
		top = 0;
	}

	void push(int x) {
		if (isFull()) {
			//System.out.println("Stack is full");
			return;
		}
		top++;
		count++;
		stack[top] = x;
	}

	int pop() {
		if (isEmpty()) {
			//System.out.println("Stack is empty");
			return -1;
		}
		top--;
		count--;
		return stack[top + 1];
	}

	void initialize() {
		count = 0;
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

	int size() {
		return count;
	}
}
