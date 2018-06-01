class AreaStack {
	private final int MAX = 20000;
	private Area[] stack;
	private int top;
	private int count;

	AreaStack() {
		stack = new Area[MAX];
		top = 0;
	}

	void push(Area x) {
		if (isFull()) {
			//System.out.println("Stack is full");
			return;
		}
		top++;
		count++;
		stack[top] = x;
	}

	Area pop() {
		if (isEmpty()) {
			//System.out.println("Stack is empty");
			return null;
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

	void print() {
		System.out.print(this.size());
		for (int i = 1; i < top + 1; i++) {
			System.out.print(" " + stack[i].area);
		}
		System.out.println();
	}
}
