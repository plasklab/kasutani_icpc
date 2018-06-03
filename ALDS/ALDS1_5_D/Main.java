import java.util.*;

class Main {
	long cnt = 0;
	final int INFT = Integer.MAX_VALUE;

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

		// System.out.println(bubbleSort(a));
		mergeSort(a, 0, a.length);
		System.out.println(cnt);
	}

	long bubbleSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = a.length - 1; j > i; j--) {
				if (a[j] < a[j - 1]) {
					int swp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = swp;
					cnt++;
				}
			}
		}

		return cnt;
	}

	void mergeSort(int[] a, int left, int right) {
		if (left + 1 < right) {
			int mid = (left + right) / 2;
			mergeSort(a, left, mid);
			mergeSort(a, mid, right);
			merge(a, left, mid, right);
		}
	}

	void merge(int[] a, int left, int mid, int right) {
		int n1 = mid - left;
		int n2 = right - mid;
		int[] l = new int[n1 + 1];
		for (int i = 0; i < n1; i++)
			l[i] = a[left + i];
		int[] r = new int[n2 + 1];
		for (int i = 0; i < n2; i++) 
			r[i] = a[mid + i];
		l[n1] = r[n2] = INFT;

		int i = 0, j = 0;
		for (int k = left; k < right; k++) {
			if (l[i] <= r[j]) {
				a[k] = l[i];
				i++;
			} else {
				a[k] = r[j];
				cnt += n1 - i;
				// System.out.println(cnt);
				// System.out.println(l[i] + " " + r[j] + " : " + n1 + " - " + i + " = " + (n1 - i));
				j++;
			}
		}
	}
}