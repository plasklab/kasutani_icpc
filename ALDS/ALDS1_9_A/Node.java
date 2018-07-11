class Node {
	int id;
	int key;
	Node parent;
	Node left;
	Node right;

	Node (int id, int key) {
		this.id = id;
		this.key = key;
		this.parent = null;
		this.left = null;
		this.right = null;
	}

	void setParent(Node node) {
		this.parent = node;
	}

	void setLeft(Node node) {
		this.left = node;
	}

	void setRight(Node node) {
		this.right = node;
	}

	void print() {
	  System.out.print("node " + id + ": key = " + key + ", ");
	  if (parent != null)
	  	System.out.print("parent key = " + parent.key + ", ");
	  if (left != null)
	  	System.out.print("left key = " + left.key + ", ");
	  if (right != null)
	  	System.out.print("right key = " + right.key + ", ");
	  System.out.println();
	}
}