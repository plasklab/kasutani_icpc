import java.util.*;
import java.lang.*;

class Main {
	int n;
	int[] preorder;
	int[] inorder;
	StringBuilder str;
	int attension = 0;

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

		Node root = createTree(0, inorder.length);

		str = new StringBuilder();
		str.append(postorder(root));
		str.deleteCharAt(str.length() - 1);
		System.out.println(str);
		
	}

	Node createTree(int from, int to) {
		int id = -1;
		int i = from;
		for (; i < to; i++) {
			if (inorder[i] == preorder[attension]) {
				id = inorder[i];
				attension++;
				break;
			}
		}
		if (id == -1) return null;
		Node n = new Node(id);
		n.setLeft(createTree(from, i));
		n.setRight(createTree(i + 1, to));

		return n;
	}

	String postorder(Node node) {
		if (node.left != null)
			str.append(postorder(node.left));
		if (node.right != null)
			str.append(postorder(node.right));
		return node.print();
	}
}