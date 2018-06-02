import java.util.*;

class Main {
	Node head = new Node(' ');

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
		char[] c = s.toCharArray();
		if (find(s)) return;
		Node n = head;
		for (int i = 0; i < c.length; i++) {
			if (!n.find(c[i])) n.add(new Node(c[i]));
			n = n.get(c[i]);
		}
		n.last = true;
	}

	boolean find(String s) {
		char[] c = s.toCharArray();
		Node n = head;
		for (int i = 0; i < c.length; i++) {
			n = n.get(c[i]);
			if (n == null) return false;
		}
		if (n.last) return true;
		return false;
	}
}