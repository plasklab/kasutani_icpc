import java.util.*;

class Main {
	int[] trucks;
	int[] w;
	int max;
	int sum;

	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		max = 0;
		trucks = new int[k];
		w = new int[n];
		for (int i = 0; i < n; i++) {
			w[i] = scan.nextInt();
			if (max < w[i]) max = w[i];
			sum += w[i];
		}

		System.out.println(search(max, sum));
	}

	int search(int min, int max) {
		int p = 0;
		int lower = min;
		int upper = max;
		while (lower < upper) {
			boolean l = solve(lower);
			boolean u = solve(upper);
			if (l == false && u == true) {
				p = (lower + upper) / 2;
				upper = p;
			} else if (l == true && u == true) {
				return lower;
			} else if (l == false && u == false) {
				upper = max;
				lower = p;
			}
		}
		return p + 1;
	}

	boolean solve(int p) {
		int j = 0;
		for (int i = 0; i < trucks.length; i++) {
			long truck = 0;
			while (j < w.length) {
				truck += w[j];

				if (truck > p) {
					break;
				}
				j++;
			}
			if (j == w.length) return true;
		}

		return false;
	}



/*
	int minMaximumcapacity() {
		int p = wMax;
		while (true) {
			int j = 0;
			for (int i = 0; i < trucks.length; i++) {
				int v = numBags(p, j);
				if (v == 0) { 
					break;
				}
				j += v;
			}
			if (j == w.length)
				break;
			p++;
		}
		return p;
	}

	int numBags(long p, int j) {
		int truck = 0;
		int v = 0;
		while (j < w.length) {
			truck += w[j];
			if (truck > p) break;
			v++;
			j++;
		}
		return v;
	}
*/
}