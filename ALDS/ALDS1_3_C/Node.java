class Node {
	Node prev;
	Node next;
	int n;

	Node(Node prev, Node next, int n) {
		this.prev = prev;
		this.next = next;
		this.n = n;
	}
}