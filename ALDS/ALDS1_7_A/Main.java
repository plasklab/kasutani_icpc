import java.util.*;

class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Node[] nodes = new Node[n];

		for (int i = 0; i < n; i++) {
			int id = scan.nextInt();
			int k = scan.nextInt();
			int[] c = new int[k];
			for (int j = 0; j < k; j++) {
				c[j] = scan.nextInt();
			}
			nodes[i] = new Node(id, c);
		}

		selectionSort(nodes);
		addDate(nodes);
		printArray(nodes);

	}

	void selectionSort(Node[] nodes) {
		for (int i = 0; i < nodes.length; i++) {
			int minj = i;
			for (int j = i; j < nodes.length; j++) {
				if (nodes[minj].id > nodes[j].id)
					minj = j;
			}
			if (i != minj) {
				Node swp = nodes[i];
				nodes[i] = nodes[minj];
				nodes[minj] = swp;
			}
		}
	}

	void addDate(Node[] nodes) {
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].children.length != 0) {
				addParent(nodes, nodes[i]);
			}
		}
		addType(nodes);
		Node root = searchRoot(nodes);
		for (int i = 0; i < root.children.length; i++) {
			addDepth(nodes, searchNode(nodes, root.children[i]));
		}
	}

	void addParent(Node[] nodes, Node n) {
		for (int i = 0; i < nodes.length; i++) {
			for (int j = 0; j < n.children.length; j++) {
				if (nodes[i].id == n.children[j]) {
					nodes[i].parent = n.id;
					break;
				}
			}
		}
	}

	void addType (Node[] nodes) {
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].parent != -1 && nodes[i].children.length != 0)
				nodes[i].type = "internal node";
			else if (nodes[i].parent != -1 && nodes[i].children.length == 0)
				nodes[i].type = "leaf";
		}
	}

	void addDepth(Node[] nodes, Node n) {
		n.depth = searchNode(nodes, n.parent).depth + 1;
		for (int i = 0; i < n.children.length; i++) {
			addDepth(nodes, searchNode(nodes, n.children[i]));
		}
	}

	Node searchRoot(Node[] nodes) {
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].type.equals("root")) return nodes[i];
		}

		return null;
	}

	Node searchNode(Node[] nodes, int id) {
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].id == id) return nodes[i];
		}

		return null;
	}

	void printArray(Node[] nodes) {
		for (int i = 0; i < nodes.length; i++) {
			nodes[i].print();
		}
	}
}