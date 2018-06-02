import java.util.*;

class Main {
	int cnt = 0;

	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] s = new int[n];
		for (int i = 0; i < n; i++) {
			s[i] = scan.nextInt();
		}

		int q = scan.nextInt();
		int[] t = new int[q];
		for (int i = 0; i < q; i++) {
			t[i] = scan.nextInt();
		}

		for (int i = 0; i < q; i++) {
			BinarySearch(s, t[i]);
		}

		System.out.println(cnt);
	}

	void BinarySearch(int[] s, int t) {
		int left = 0;
		int right = s.length;
		while (left < right) {
			int mid = (left + right) / 2;
			// System.out.println(left + " " + mid + " " + right);
			if (s[mid] == t) {
				cnt++;
				break;
			}
			else if (t < s[mid]) right = mid;
			else left = mid + 1;
		}
	}
}