class Node {
	int key;
	int priority;
	Node left;
	Node right;
	Node parent;

	Node (int key, int priority, Node left, Node right) {
		this.key = key;
		this.priority = priority;
		this.left = left;
		this.right = right;
		this.parent = null;
	}

	void print() {
		System.out.print(" " + this.key);
	}

}