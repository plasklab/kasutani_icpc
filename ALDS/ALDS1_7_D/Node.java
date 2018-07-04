class Node {
	int id;
	Node left;
	Node right;

	Node (int id) {
		this.id = id;
		this.left = null;
		this.left = null;
	}

	void setLeft(Node n) {
		this.left = n;
	}

	void setRight(Node n) {
		this.right = n;
	}

	String print() {
		return String.valueOf(this.id) + " ";
	}
}