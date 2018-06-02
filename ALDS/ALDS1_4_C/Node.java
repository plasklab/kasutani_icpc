import java.util.*;

class Node {
	char c;
	List<Node> list = new LinkedList<Node>();
	boolean last;

	Node(char c) {
		this.c = c;
		this.last = false;
	}

	boolean find(char c) {
		for (Node n : list) {
			if (n.c == c) return true;
		}
		return false;
	}

	Node get(char c) {
		for (Node n : list) {
			if (n.c == c) return n;
		}
		return null;
	}

	void add(Node n) {
		list.add(n);
	}

	void print() {
		for (Node n : list) {
			System.out.print(n.c);
			n.print();
			System.out.println();
		}
	}
}