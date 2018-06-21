class Node {
	int id;
	int left;
	int right;
	int parent;

	Node (int id, int left, int right) {
		this.id = id;
		this.left = left;
		this.right = right;
		this.parent = -1;
	}

	void print() {
		System.out.print(" " + this.id);
	}

	void printd() {
		System.out.println(id + " " + parent + " " + left + " " + right);
	}
}