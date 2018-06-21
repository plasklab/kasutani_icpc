import java.util.*;

class Main {
	Node[] nodes = new Node[25];
	int maxId = 0;

	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int id = scan.nextInt();
			if (maxId < id) maxId = id;
			int left = scan.nextInt();
			int right = scan.nextInt();
			nodes[id] = new Node(id, left, right);
		}
		for (int i = 0; i <= maxId; i++) {
			if (nodes[i] != null)
				setParent(nodes[i]);
		}

		int root = searchRoot();

		System.out.println("Preorder");
		preorder(nodes[root]);
		System.out.println();

		System.out.println("Inorder");
		inorder(nodes[root]);
		System.out.println();

		System.out.println("Postorder");
		postorder(nodes[root]);
		System.out.println();

	}

	void setParent(Node n) {
		if (n.left != -1)
			nodes[n.left].parent = n.id;
		if (n.right != -1)
			nodes[n.right].parent = n.id;
	}

	int searchRoot() {
		for (int i = 0; i <= maxId; i++) {
			if (nodes[i] == null) continue;
			if (nodes[i].parent == -1) return i;
		}
		return -1;
	}

	void preorder(Node n) {
		n.print();
		if (n.left != -1)
			preorder(nodes[n.left]);
		if (n.right != -1)
			preorder(nodes[n.right]);
	}

	void inorder(Node n) {
		if (n.left != -1)
			inorder(nodes[n.left]);
		n.print();
		if (n.right != -1)
			inorder(nodes[n.right]);
	}

	void postorder(Node n) {
		if (n.left != -1)
			postorder(nodes[n.left]);
		if (n.right != -1)
			postorder(nodes[n.right]);
		n.print();
	}

	void printAll() {
		System.out.println("============");
		for (int i = 0; i <= maxId; i++) {
			if (nodes[i] == null) continue;
			nodes[i].printd();
		}
		System.out.println("============");
	}
}