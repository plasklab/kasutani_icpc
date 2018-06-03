import java.util.*;
import java.lang.*;

class Main {
	/*
	Point p1;
	Point p2;
	*/
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Point p1 = new Point(0, 0);
		Point p2 = new Point(100, 0);
		
		p1.print();
		koch(n, p1, p2);
		p2.print();
	}

	void koch(int n, Point p1, Point p2) {
		if (n == 0) return;

		double sx = (2 * p1.x + p2.x) / 3;
		double sy = (2 * p1.y + p2.y) / 3;
		Point s = new Point(sx, sy);
		double tx = (p1.x + 2 * p2.x) / 3;
		double ty = (p1.y + 2 * p2.y) / 3;
		Point t = new Point(tx, ty);
		double deg = 60;
		double rad = Math.toRadians(deg);
		double ux = (t.x - s.x) * Math.cos(rad) - (t.y - s.y) * Math.sin(rad) + s.x;
		double uy = (t.x - s.x) * Math.sin(rad) + (t.y - s.y) * Math.cos(rad) + s.y;
		Point u = new Point(ux, uy);

		koch(n - 1, p1, s);
		// System.out.print("s :");
		s.print();
		koch(n - 1, s, u);
		// System.out.print("u :");
		u.print();
		koch(n - 1, u, t);
		// System.out.print("t :");
		t.print();
		koch(n - 1, t, p2);
	}
}