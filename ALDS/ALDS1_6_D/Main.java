import java.util.*;

class Main {
	int minCost = 0;

	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] w = new int[n];

		for (int i = 0; i < n; i++) {
			w[i] = scan.nextInt();
		}

		selectionSort(w);
		System.out.println(minCost);
	}

	void selectionSort(int[] w) {
		for (int i = 0; i < w.length; i++) {
			int minj = i;
			for (int j = i; j < w.length; j++) {
				if (w[minj] > w[j])
					minj = j;
			}
			if (i != minj) {
				int swp = w[i];
				w[i] = w[minj];
				w[minj] = swp;
				minCost += w[i] + w[minj];
			}
		}
	}
}