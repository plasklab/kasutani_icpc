import java.util.*;

class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int h = scan.nextInt();
		Node[] a = new Node[h];

		for (int i = 0; i < h; i++) {
			Node n = new Node(i + 1, scan.nextInt());
			insert(a, n);
		}

		printAll(a);
	}

	void insert(Node[] array, Node n) {
		if (n.id != 1 && n.id % 2 == 0) {
			n.setParent(array[n.id / 2 - 1]);
			array[n.id / 2 - 1].setLeft(n);
		} else if (n.id != 1 && n.id % 2 == 1) {
			n.setParent(array[n.id / 2 - 1]);
			array[n.id / 2 - 1].setRight(n);
		}
		array[n.id - 1] = n;
	}

	void printAll(Node[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i].print();
		}
	}
}