import java.util.*;

class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int q = scan.nextInt();
		Queue queue = new Queue();

		for (int i = 0; i < n; i++) {
			Task t = new Task(scan.next(), scan.nextInt());
			queue.enqueue(t);
		}
		roundRobinScheduling(queue, q);
	}

	void roundRobinScheduling(Queue queue, int q) {
		int total = 0;
		while (!queue.isEmpty()) {
			Task current = queue.dequeue();
			if (current.time <= q) {
				total += current.time;
				System.out.println(current.name + " " + total);
			} else {
				total += q;
				current.time -= q;
				queue.enqueue(current);
			}
		}
	}
}