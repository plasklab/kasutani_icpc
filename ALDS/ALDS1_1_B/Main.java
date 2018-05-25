import java.util.*;

class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);

		int x = scan.nextInt();
		int y = scan.nextInt();

		System.out.println(gcd(x, y));
	}

	int gcd(int x, int y) {
		if (x > y) swap(x, y);

		while (y != 0) {
			int r = x % y;
			x = y;
			y = r;
		}
		return x;
	}

	void swap(int x, int y) {
		int swap = x;
		x = y;
		y = swap;
	}
}