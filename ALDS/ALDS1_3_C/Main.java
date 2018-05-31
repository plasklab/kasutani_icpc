import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		DLinkedList dll = new DLinkedList();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		try {
			n = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			System.out.println(e);
		}
		for (int i = 0; i < n; i++) {
			String line = null;
			try {
				line = br.readLine();
			} catch (Exception e) {
				System.out.println(e);
			}
			String[] s = line.split(" ");
			if (s[0].equals("insert")) {
				dll.insert(Integer.parseInt(s[1]));
			} else if (s[0].equals("delete")) {
				dll.delete(Integer.parseInt(s[1]));
			} else if (s[0].equals("deleteLast")) {
				dll.deleteLast();
			} else if (s[0].equals("deleteFirst")) {
				dll.deleteFirst();
			}
		}
		dll.print();
	}
}