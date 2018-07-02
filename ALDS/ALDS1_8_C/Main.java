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
			} else if (s.equals("find")) {
				if (find(root, scan.nextInt()) != null)
					System.out.println("yes");
				else
					System.out.println("no");
			}  else if (s.equals("delete")) {
				delete(root, scan.nextInt());
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

	Node find(Node n, int num) {
		if (n == null) return null;
		if (n.key == num) {
			return n;
		} else if (n.key > num) {
			return find(n.left, num);
		} else if (n.key < num) {
			return find(n.right, num);
		}

		return null;
	}

	Node minNode(Node n) {
		if (n.left != null)
			return minNode(n.left);
		return n;
	}

	void delete(Node root, int num) {
		Node n = find(root, num);
		if (n == null) return;

		Node p = n.parent;
		if (n.left == null && n.right == null) {
			if (p.left == n) p.left = null;
			else if (p.right == n) p.right = null;
		} else if (n.left != null && n.right != null) {
			Node next = minNode(n.right);
			int key = next.key;
			delete(root, key);
			n.key = key;
		} else if (n.left == null) {
			if (p.left == n) p.left = n.right;
			else p.right = n.right;
			n.right.parent = p;
		} else if (n.right == null) {
			if (p.left == n) p.left = n.left;
			else p.right = n.left;
			n.left.parent = p;
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