class Queue {
	private final int MAX = 100000;
	private Task[] queue = new Task[MAX];
	private int head;
	private int tail;

	Queue() {
		head = 0;
		tail = 0;
	}

	void initialize() {
		tail = 0;
		head = 0;
	}

	void enqueue(Task t) {
		if (isFull()) {
			System.out.println("Queue is full");
			return;
		}
		queue[tail] = t;
		if (tail + 1 == MAX)
			tail = 0;
		else
			tail++;
	}

	Task dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}
		Task t = queue[head];
		if (head + 1 == MAX)
			head = 0;
		else
			head++;
		return t;
	}

	boolean isEmpty() {
		if (head == tail) return true;
		return false;
	}

	boolean isFull() {
		if (head == (tail + 1) % MAX) return true;
		return false;
	}
}