import java.util.*;

class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] r = new int[n];

		for (int i = 0; i < n; i++) {
			r[i] = scan.nextInt();
		}

		System.out.println(max(r, n));
	}

	long max(int[] r, int n) {
		long maxv = (long)Math.pow(10, 9) * -1;
		int minv = r[0];

		for (int i = 1; i < n; i++) {
			long val = r[i] - minv;
			if (val > maxv)
				maxv = val;
			if (r[i] < minv) 
				minv = r[i];
		}

		return maxv;
	}
}