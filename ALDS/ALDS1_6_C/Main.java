import java.util.*;

class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Card[] a = new Card[n];


		for (int i = 0; i < n; i++) {
			String s = scan.next();
			int num = scan.nextInt();
			a[i] = new Card(num, s, i);
		}

		quicksort(a, 0, a.length - 1);
		printValidate(validate(a));
		printArray(a);
	}

	void quicksort(Card[] a, int p, int r) {
		if (p < r) {
			int q = partition(a, p, r);
			quicksort(a, p, q - 1);
			quicksort(a, q + 1, r);
		}
	}

	int partition(Card[] a, int p, int r) {
		Card x = a[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (a[j].value <= x.value) {
				i++;
				Card swp = a[i];
				a[i] = a[j];
				a[j] = swp;
			}
		}
		Card swp = a[i + 1];
		a[i + 1] = a[r];
		a[r] = swp;

		return i + 1;
	}

	void printValidate(boolean b) {
		if (b) System.out.println("Stable");
		else System.out.println("Not stable");
	}

	boolean validate(Card[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i].value == a[i + 1].value && a[i].count > a[i + 1].count)
				return false;
			if (a[i].value > a[i + 1].value)
				return false;
		}
		return true;
	}

	void printArray(Card[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i].print();
		}
	}
}