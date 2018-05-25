import java.util.*;

class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (isPrime(scan.nextInt())) count++;
		}

		System.out.println(count);
	}

	boolean isPrime(int n) {
		if (n == 2) return true;

		if (n < 2 || n % 2 == 0) 
			return false;

		int i = 3;
		while (i <= Math.sqrt(n)) {
			if (n % i == 0) return false;
			i += 2;
		}

		return true;
	}
}