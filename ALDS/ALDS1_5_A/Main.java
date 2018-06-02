import java.util.*;

class Main {
	int[] a;
	int n;
	int q;
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = scan.nextInt();
		q = scan.nextInt();
		for (int i = 0; i < q; i++) {
			if (solve(0, scan.nextInt())) 
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}

	boolean solve(int i, int m) {
		if (m == 0) 
			return true;
		if (i >= n)
			return false;
		return solve(i + 1, m) || solve(i + 1, m - a[i]);
	}
}