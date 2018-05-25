import java.util.*;

class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] array = new int[n];

		for (int i = 0; i < array.length; i++) {
			array[i] = scan.nextInt();
		}

		printArray(array);
		insertionSort(array, n);
	}

	void insertionSort(int[] array, int n) {
		for (int i = 1; i < n; i++) {
			int v = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > v) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = v;
			printArray(array);
		}
	}

	void printArray(int[] array) {
		int i = 0;
		for (; i < array.length - 1; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println(array[i]);
	}
}
