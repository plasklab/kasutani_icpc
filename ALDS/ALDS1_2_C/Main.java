import java.util.*;

class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Card[] c = new Card[n];
		Card[] c2 = new Card[n];
		int[] numCounter = new int[9];

		for (int i = 0; i < n; i++) {
			String s = scan.next();
			int num = Character.getNumericValue(s.charAt(1));
			numCounter[num - 1]++;
			c[i] = new Card(s, num, numCounter[num - 1]);
			c2[i] = new Card(s, num, numCounter[num - 1]);
		}

		bubbleSort(c, n);
		selectionSort(c2, n);
	}

	void bubbleSort(Card[] c, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j > i; j--) {
				if (c[j].value < c[j-1].value) {
					Card swp = c[j];
					c[j] = c[j - 1];
					c[j - 1] = swp;
				}
			}
		}
		printCard(c, n);
		printValidate(validate(c, n));
	}

	void selectionSort(Card[] c, int n) {
		for (int i = 0; i < n; i++) {
			int minj = i;
			for (int j = i; j < n; j++) {
				if (c[j].value < c[minj].value)
					minj = j;
			}
			Card swp = c[i];
			c[i] = c[minj];
			c[minj] = swp;
		}
		printCard(c, n);
		printValidate(validate(c, n));
	}

	boolean validate(Card[] c, int n) {
		for (int i = 0; i < n - 1; i++) {
			if (c[i].value == c[i + 1].value && c[i].count > c[i + 1].count)
				return false;
			if (c[i].value > c[i + 1].value)
				return false;
		}
		return true;
	}

	void printCard(Card[] array, int n) {
		int i = 0;
		for (; i < n - 1; i++) {
			System.out.print(array[i].card + " ");
		}
		System.out.println(array[i].card);
	}

	void printValidate(boolean b) {
		if (b) System.out.println("Stable");
		else System.out.println("Not stable");
	}
}