class Node {
	int id;
	int parent;
	int depth;
	String type;
	int[] children;


	Node(int id, int[] c) {
		this.id = id;
		this.children = c;
		this.parent = -1;
		this.depth = 0;
		this.type = "root";
	}

	void print() {
		System.out.print("node " + id + ": ");
		System.out.print("parent = " + parent + ", ");
		System.out.print("depth = " + depth + ", ");
		System.out.print(type + ", ");
		System.out.print("[");
		for (int i = 0; i < children.length; i++) {
			System.out.print(children[i]);
			if (i != children.length - 1)
				System.out.print(", ");
		}
		System.out.print("]");
		System.out.println();
	}
}