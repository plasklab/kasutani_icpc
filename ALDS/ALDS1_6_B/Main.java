import java.util.*;

class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}

		int p = partition(a, 0, a.length - 1);
		printArray(a, p);
	}

	int partition(int[] a, int p, int r) {
		int x = a[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (a[j] <= x) {
				i++;
				int swp = a[i];
				a[i] = a[j];
				a[j] = swp;
			}
		}
		int swp = a[i + 1];
		a[i + 1] = a[r];
		a[r] = swp;

		return i + 1;
	}

	void printArray(int[] a, int p) {
		for (int i = 0; i < a.length - 1; i++) {
			if (i == p) {
				System.out.print("[" + a[i] + "] ");
			} else {
				System.out.print(a[i] + " ");
			}
		}
		System.out.println(a[a.length -1]);
	}
}