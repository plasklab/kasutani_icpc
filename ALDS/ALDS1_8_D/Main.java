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
				root = insert(root, scan.nextInt(), scan.nextInt());
			} else if (s.equals("find")) {
				if (find(root, scan.nextInt()) != null)
					System.out.println("yes");
				else
					System.out.println("no");
			}  else if (s.equals("delete")) {
				root = delete(root, scan.nextInt());
			} else if (s.equals("print")) {
				print(root);
			}
		}
	}

	Node insert(Node t, int key, int priority) {
		if (t == null)
			return new Node(key, priority, null, null);
		if (key == t.key)
			return t;

		if (key < t.key) {
			t.left = insert(t.left, key, priority);
			if (t.priority < t.left.priority) {
				t = rightRotate(t);
			}
		} else {
			t.right = insert(t.right, key, priority);
			if (t.priority < t.right.priority) {
				t = leftRotate(t);
			}
		}

		return t;
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

	Node delete(Node t, int key) {
		if (t == null)
			return null;
		if (key < t.key) {
			t.left = delete(t.left, key);
		} else if (key > t.key) {
			t.right = delete(t.right, key);
		} else {
			return _delete(t, key);
		}

		return t;
	}

	Node _delete(Node t, int key) {
		if (t.left == null && t.right == null) {
			return null;
		} else if (t.left == null) {
			t = leftRotate(t);
		} else if (t.right == null) {
			t = rightRotate(t);
		} else {
			if (t.left.priority > t.right.priority) {
				t = rightRotate(t);
			} else {
				t = leftRotate(t);
			}
		}

		return delete(t, key);
	}

	Node rightRotate(Node t) {
		Node s = t.left;
		t.left = s.right;
		s.right = t;
		return s;
	}

	Node leftRotate(Node t) {
		Node s = t.right;
		t.right = s.left;
		s.left = t;
		return s;
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