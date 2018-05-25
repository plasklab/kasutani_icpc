class Card {
	String card;
	int value;
	char mark;
	int count;

	Card(String card, int value, int count) {
		this.card = card;
		this.mark = card.charAt(0);
		this.value = value;
		this.count = count;
	}
}