import java.util.*;

class Main {
	int maxId = 0;
	int[] idList;
	Node root;

	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Node[] nodes = new Node[100000];
		idList = new int[n];

		for (int i = 0; i < n; i++) {
			int id = scan.nextInt();
			if (maxId < id) maxId = id;
			idList[i] = id;
			int k = scan.nextInt();
			int[] c = new int[k];
			for (int j = 0; j < k; j++) {
				c[j] = scan.nextInt();
			}
			nodes[id] = new Node(id, c);
		}

		addDate(nodes);
		printArray(nodes);

	}

	void addDate(Node[] nodes) {
		for (int i = 0; i < idList.length; i++) {
			if (nodes[idList[i]].children.length != 0) {
				addParent(nodes, nodes[idList[i]]);
			}
		}
		addType(nodes);

		for (int i = 0; i < root.children.length; i++) {
			addDepth(nodes, nodes[root.children[i]]);
		}
	}

	void addParent(Node[] nodes, Node n) {
		for (int i = 0; i < n.children.length; i++) {
			nodes[n.children[i]].parent = n.id;
		}
	}

	void addType (Node[] nodes) {
		for (int i = 0; i < idList.length; i++) {
			if (nodes[idList[i]].parent != -1 && nodes[idList[i]].children.length != 0)
				nodes[idList[i]].type = "internal node";
			else if (nodes[idList[i]].parent != -1 && nodes[idList[i]].children.length == 0)
				nodes[idList[i]].type = "leaf";
			else
				root = nodes[idList[i]];
		}
	}

	void addDepth(Node[] nodes, Node n) {
		n.depth = nodes[n.parent].depth + 1;
		for (int i = 0; i < n.children.length; i++) {
			addDepth(nodes, nodes[n.children[i]]);
		}
	}

	void printArray(Node[] nodes) {
		for (int i = 0; i <= maxId; i++) {
			if (nodes[i] == null) continue;
			nodes[i].print();
		}
	}
}