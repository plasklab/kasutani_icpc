import java.util.*;

class Main {
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

		selectionSort(array, n);
	}

	void selectionSort(int[] array, int n) {
		int swpCnt = 0;

		for (int i = 0; i < n; i++) {
			int minj = i;
			for (int j = i; j < n; j++) {
				if (array[minj] > array[j]) {
					minj = j;
				}
			}
			if (i != minj) {
				int swp = array[i];
				array[i] = array[minj];
				array[minj] = swp;
				swpCnt++;
			}
		}
		printArray(array, n);
		System.out.println(swpCnt);
	}

	void printArray(int[] array, int n) {
		int i = 0;
		for (; i < n - 1; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println(array[i]);
	}
}