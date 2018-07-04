import java.util.*;
import java.lang.*;

class Main {
	int n;
	int[] a;
	int[] b;
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		a = new int[n];
		b = new int[n];
		int k = 0;

		for (int i = 0; i < n; i++) {
			if (scan.hasNext())
				a[i] = Integer.parseInt(scan.next());
			if (k < a[i]) k = a[i];
		}

		countingSort(k);
		System.out.println(builderArray(b));

	}

	void countingSort(int k) {
		int[] c = new int[k + 1];
		for (int i = 0; i <= k; i++) {
			c[i] = 0;
		}

		for (int i = 0; i < n; i++) {
			c[a[i]]++;
		}

		for (int i = 1; i <= k; i++) {
			c[i] = c[i] + c[i - 1];
		}

		for (int i = n - 1; i >= 0; i--) {
			b[c[a[i]] - 1] = a[i];
			c[a[i]]--;
		}
	}

	String builderArray(int[] b) {
		StringBuilder str = new StringBuilder();
		str.append(b[0]);
		for (int i = 1; i < b.length; i++) {
			str.append(" " + b[i]);
		}
		return str.toString();
	}
}
