class Node {
	int id;
	Node parent;
	Node left;
	Node right;

	Node (int id, Node parent) {
		this.id = id;
		this.parent = parent;
		this.left = null;
		this.left = null;
	}

	void setLeft(Node n) {
		System.out.print("left ");
		n.parent.print();
		System.out.print(" ");
		n.print();
		System.out.println();
		this.left = n;
	}

	void setRight(Node n) {
		System.out.print("right ");
		n.parent.print();
		System.out.print(" ");
		n.print();
		System.out.println();
		this.right = n;
	}

	void print() {
		System.out.print(this.id);
	}
}