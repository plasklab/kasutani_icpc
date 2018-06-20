import java.util.*;

class Main {
	int maxId = 0;
	Node[] nodes = new Node[25];
	int[] idList;
	Node root;

	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		idList = new int[n];

		for (int i = 0; i < n; i++) {
			int id = scan.nextInt();
			if (maxId < id) maxId = id;
			idList[i] = id;
			int left = scan.nextInt();
			int right = scan.nextInt();
			nodes[id] = new Node(id, left, right);
		}

		setData();
		printAll();
	}

	void setData() {
		for (int i = 0; i < idList.length; i++) {
			setParentAndDeg(nodes[idList[i]]);
		}
		setType();
		for (int i = 0; i < idList.length; i++) {
			setSibling(nodes[idList[i]]);
		}
		if (root.left != -1)
			setDepth(nodes[root.left]);
		if (root.right != -1)
			setDepth(nodes[root.right]);

		for (int i = 0; i < idList.length; i++) {
			nodes[idList[i]].height = setHeight(nodes[idList[i]]);
		}
	}

	void setParentAndDeg(Node n) {
		int cnt = 0;
		if (n.left != -1) {
			nodes[n.left].parent = n.id;
			cnt++;
		}
		if (n.right != -1) {
			nodes[n.right].parent = n.id;
			cnt++;
		}
		n.degree = cnt;
	}

	void setType() {
		for (int i = 0; i < idList.length; i++) {
			if (nodes[idList[i]].parent != -1) {
				if (nodes[idList[i]].degree != 0)
					nodes[idList[i]].type = "internal node";
				else if (nodes[idList[i]].degree == 0)
					nodes[idList[i]].type = "leaf";
			} else
				root = nodes[idList[i]];
		}
	}

	void setSibling(Node n) {
		if (n.parent == -1) return;
		int sId = nodes[n.parent].left;
		if (sId != n.id) {
			n.sibling = sId;
			return;
		} else {
			n.sibling = nodes[n.parent].right;
		}
	}

	void setDepth(Node n) {
		n.depth = nodes[n.parent].depth + 1;
		if (n.left != -1)
			setDepth(nodes[n.left]);
		if (n.right != -1)
			setDepth(nodes[n.right]);
	}

	int setHeight(Node n) {
		if (n.type.equals("leaf")) {
			return 0;
		} else {
			int lh = -1;
			int rh = -1;
			if (n.left != -1) {
				lh = setHeight(nodes[n.left]);
			}
			if (n.right != -1) {
				rh = setHeight(nodes[n.right]);
			}
			if (lh > rh)
				return lh + 1;
			else
				return rh + 1;
		}
	}

	void printAll() {
		for (int i = 0; i <= maxId; i++) {
			if (nodes[i] == null) continue;
			nodes[i].print();
		}
	}
}