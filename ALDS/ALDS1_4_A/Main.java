import java.util.*;

class Main {
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
		int[] t = new int[n];
		for (int i = 0; i < q; i++) {
			t[i] = scan.nextInt();
		}

		int cnt = 0;
		for (int i = 0; i < q; i++) {
			for (int j = 0; j < n; j++) {
				if (s[j] == t[i]) {
					cnt++;
					break;
				}
			}
		}

		System.out.println(cnt);
	}
}