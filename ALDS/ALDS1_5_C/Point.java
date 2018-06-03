class Point {
	double x, y;

	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	void print() {
		System.out.printf("%8f %8f\n", this.x, this.y);
	}
}
