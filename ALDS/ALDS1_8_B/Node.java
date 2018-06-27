class Node {
	int key;
	Node left;
	Node right;
	Node parent;

	Node (int key, Node left, Node right) {
		this.key = key;
		this.left = left;
		this.right = right;
		this.parent = null;
	}

	void print() {
		System.out.print(" " + this.key);
	}

}