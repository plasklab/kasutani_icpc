import java.util.*;

class Main {
	int cnt;

	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = scan.nextInt();
		}

		shellSort(array, n);
	}

	void shellSort(int[] array, int n) {
		cnt = 0;
		int m = 0;
		int[] g = new int[100];
		int h = n;

		while (true) {
			h /= 2;
			if (h <= 1) {
				g[m] = 1;
				m++;
				break;
			} else {
				g[m] = h;
				m++;
			}
		}

		for (int i = 0; i < m; i++) {
			insertionSort(array, n, g[i]);
		}

		System.out.println(m);
		printG(g, m);
		System.out.println(cnt);
		printArray(array, n);
	}

	void insertionSort(int[] array, int n, int g) {
		for (int i = g; i < n; i++) {
			int v = array[i];
			int j = i - g;
			while (j >= 0 && array[j] > v) {
				array[j + g] = array[j];
				j -= g;
				cnt++;
			}
			array[j + g] = v;
		}
	}

	void printG(int[] g, int m) {
		int i = 0;
		for (; i < m - 1; i++) {
			System.out.print(g[i] + " ");
		}
		System.out.println(g[i]);
	}

	void printArray(int[] array, int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(array[i]);
		}
	}
}