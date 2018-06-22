import java.util.*;

class Main {
	Node root;
	int n;
	int[] preorder;
	int[] inorder;
	int j = 0;
	int k = 0;

	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		preorder = new int[n];
		inorder = new int[n];

		for (int i = 0; i < n; i++) {
			preorder[i] = scan.nextInt();
		}
		for (int i = 0; i < n; i++) {
			inorder[i] = scan.nextInt();
		}

		root = new Node(preorder[0], null);
		j++;
		createTree(root);

		// printTree(root);
		postorder(root);
	}

	void createTree(Node node) {
		if (node.id == inorder[k]) {
			k++;
			if (j == n && k == n) return;
			searchParent(node.parent);
		} else if (node.left == null) {
			node.setLeft(new Node(preorder[j], node));
			j++;
			createTree(node.left);
		} else if (node.right == null) {
			node.setRight(new Node (preorder[j], node));
			j++;
			createTree(node.right);
		}
	}

	void searchParent(Node node) {
			// System.out.println(j + " " + k);
		/*if (node == null) {
			return;
		} else */if (node.id != inorder[k]) {
			searchParent(node.parent);
		} else {
			k++;
			createTree(node);
		}
	}

	void postorder(Node node) {
		if (node.left != null)
			postorder(node.left);
		if (node.right != null)
			postorder(node.right);
		node.print();
		System.out.print(" ");
	}

	void printTree(Node node) {
		node.print();
		System.out.print(" ");
		if (node.left != null)
			printTree(node.left);
		if (node.right != null)
			printTree(node.right);
	}
}