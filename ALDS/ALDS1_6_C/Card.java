class Card {
	int value;
	String mark;
	int count;

	Card(int value, String mark, int count) {
		this.value = value;
		this.mark = mark;
		this.count = count;
	}

	void print() {
		System.out.println(mark + " " + value);
	}
}