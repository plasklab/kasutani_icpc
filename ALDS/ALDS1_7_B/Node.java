class Node {
	int id;
	int parent;
	int sibling;
	int degree;
	int depth;
	int height;
	int left;
	int right;
	String type;

	Node (int id, int left, int right) {
		this.id = id;
		this.parent = -1;
		this.sibling = -1;
		this.left = left;
		this.right = right;
		this.degree = 0;
		this.depth = 0;
		this.height = 0;
		this.type = "root";
	}

	void print() {
		System.out.print("node " + this.id + ": ");
		System.out.print("parent = " + this.parent + ", ");
		System.out.print("sibling = " + this.sibling + ", ");
		System.out.print("degree = " + this.degree + ", ");
		System.out.print("depth = " + this.depth + ", ");
		System.out.print("height = " + this.height + ", ");
		System.out.println(this.type);
	}

}