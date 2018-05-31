class DLinkedList {
	Node head;
	Node tail;

	DLinkedList() {
		head = tail = null;
	}
	void insert(int x) {
		Node next = this.head;
		this.head = new Node(null, head, x);
		if (next != null)
			next.prev = this.head;
		if (tail == null) 
			this.tail = this.head; 
	}

	void delete(int x) {
		Node current = this.head;
		while (current != null) {
			if (current.n == x) {
				if (current.prev == null) {
					this.deleteFirst();
					return;
				}
				if (current.next == null) {
					this.deleteLast();
					return;
				}
				Node prev = current.prev;
				Node next = current.next;
				prev.next = next;
				next.prev = prev;
				return;
			}
			current = current.next;
		}
	}

	void deleteFirst() {
		if (head != null) {
			if (head == tail) {
				head = tail = null;
			} else {
				head = head.next;
				head.prev = null;
			}
		}
	}

	void deleteLast() {
		if (tail != null) {
			if (head == tail) {
				head = tail = null;
			} else {
				tail = tail.prev;
				tail.next = null;
			}
		}
	}

	void print() {
		System.out.print(head.n);
		Node current = this.head.next;
		while (current != null) {
			System.out.print(" " + current.n);
			current = current.next;
		}
		System.out.println();
	}
}