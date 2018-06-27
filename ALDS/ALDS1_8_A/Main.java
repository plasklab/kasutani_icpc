import java.util.*;

class Main {
	Node root;

	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			String s = scan.next();
			if (s.equals("insert")) {
				insert(new Node(scan.nextInt(), null, null));
			} else if (s.equals("print")) {
				print(root);
			}
		}
	}

	void insert(Node z) {
		Node y = null;
		Node x = root;

		while (x != null) {
			y = x;
			if (z.key < x.key)
				x = x.left;
			else
				x = x.right;
		}
		z.parent = y;

		if (y == null) {
			root = z;
		} else if (z.key < y.key) {
			y.left = z;
		} else {
			y.right = z;
		}
	}

	void print(Node root) {
		inorder(root);
		System.out.println();
		preorder(root);
		System.out.println();
	}

	void inorder(Node n) {
		if (n.left != null)
			inorder(n.left);
		n.print();
		if (n.right != null)
			inorder(n.right);
	}

	void preorder(Node n) {
		n.print();
		if (n.left != null)
			preorder(n.left);
		if (n.right != null)
			preorder(n.right);
	}
}