import java.util.*;

class Main {
	Node head = new Node();

	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			String order = scan.next();
			String s = scan.next();
			if (order.equals("insert"))
				insert(s);
			else if (order.equals("find")) {
				if (find(s))
					System.out.println("yes");
				else
					System.out.println("no");
			}
		}
	}

	void insert(String s) {
		int i;
		if (find(s)) return;
		Node n = head;
		for (i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A') {
				if (n.a == null) n.a = new Node();
				n = n.a;
			} else if (s.charAt(i) == 'C') {
				if (n.c == null) n.c = new Node();
				n = n.c;
			} else if (s.charAt(i) == 'G') {
				if (n.g == null) n.g = new Node();
				n = n.g;
			} else if (s.charAt(i) == 'T') {
				if (n.t == null) n.t = new Node();
				n = n.t;
			}
		}
		n.last = true;
	}

	boolean find(String s) {
		Node n = head;
		int i;
		for (i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A') {
				n = n.a;
			} else if (s.charAt(i) == 'C') {
				n = n.c;
			} else if (s.charAt(i) == 'G') {
				n = n.g;
			} else if (s.charAt(i) == 'T') {
				n = n.t;
			}
			if (n == null) return false;
		}
		if (n.last) return true;
		return false;
	}
}