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
		bubuleSort(array, n);
	}

	void bubuleSort(int[] array, int n) {
		int swpCount = 0;
		int i = 0;
		while (i < n - 1) {
			for (int j = n - 1; j > i; j--) {
				if (array[j] < array[j - 1]) {
					int swp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = swp;
					swpCount++;
					//printArray(array, n);
				}
			}
			i++;
		}
		printArray(array, n);
		System.out.println(swpCount);
	}

	void printArray(int[] array, int n) {
		int i = 0;
		for (; i < n - 1; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println(array[i]);
	}
}