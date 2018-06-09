import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	int n;
	int[] a;
	int[] b;
	int[] c = new int[10000 + 1];
	public static void main(String[] args) {
		new Main().run3();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		a = new int[n];
		b = new int[n];
		int k = 0;

		for (int i = 0; i < n; i++) {
			if (scan.hasNextInt())
				a[i] = scan.nextInt();
			if (k < a[i]) k = a[i];
		}

		countingSort(k);
		printArray(b);

	}

	void run2() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			n = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			System.out.println(e);
		}
		a = new int[n];
		b = new int[n];
		int k = 0;
		String str = null;
		try {
			str = br.readLine();
		} catch (Exception e) {
			System.out.println(e);
		}
		String[] str2 = str.split(" ", 0);
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(str2[i]);
			if (k < a[i]) k = a[i];
		}

		countingSort(k);
		printArray(b);
	}

	void run3() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		a = new int[n];
		b = new int[n];
		int k = 0;

		for (int i = 0; i < n; i++) {
			if (scan.hasNextInt()) {
				a[i] = scan.nextInt();
				c[a[i]]++;
				if (k < a[i]) k = a[i];
			}
		}
		countingSort2(k);
		printArray(b);
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

	void countingSort2(int k) {
		for (int i = 1; i <= k; i++) {
			c[i] = c[i] + c[i - 1];
		}
		for (int i = n - 1; i >= 0; i--) {
			b[c[a[i]] - 1] = a[i];
			c[a[i]]--;
		}
	}

	void printArray(int[] b) {
		int i = 0;
		System.out.print(b[i]);
		for (i = 1; i < b.length; i++) {
			System.out.print(" " + b[i]);
		}
		System.out.println();
	}
}