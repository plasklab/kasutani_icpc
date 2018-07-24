import java.util.*;

class Main {
	int minCost = 0;
	int mv;

	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] w = new int[n];
		int[] sort = new int[n];
		boolean[] flag = new boolean[n];

		for (int i = 0; i < n; i++) {
			sort[i] = scan.nextInt();
			w[i] = sort[i];
			flag[i] = true;
		}

		mv = w[0];
		for (int i = 1; i < w.length; i++) {
			if (mv > w[i]) mv = w[i];
		}

		Arrays.sort(sort);
		createCircle(w, sort, flag);
		System.out.println(minCost);
	}

	void createCircle (int[] w, int[] sort, boolean[] flag) {
		for (int i = 0; i < w.length; i++) {
			int min = 0;
			if (!flag[i]) continue;
			flag[i] = false;
			int tmp = w[i];
			int minv = tmp;
			int cnt = 1;
			while (true) {
				int index = i;
				for (int j = 0; j < sort.length; j++) {
					if (tmp == sort[j] && i != j) {
						min += tmp;
						tmp = w[j];
						if (minv > tmp) minv = tmp;
						index = j;
						cnt++;
						break;
					}
				}
				if (!flag[index]) {
					flag[index] = false;
					break;
				}
				flag[index] = false;
			}
			min += tmp;
			int m = min + minv + (cnt + 1) * mv;
			min += (cnt - 2) * minv;
			if (min > m) min = m;
			minCost += min;
		}
	}
}