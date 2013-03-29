package lab7;

public class CheckForFlush {
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		int card1 = deck.draw().getSuit();
		int card2 = deck.draw().getSuit();
		int card3 = deck.draw().getSuit();
		int card4 = deck.draw().getSuit();
		int card5 = deck.draw().getSuit();
		
		if (card1 == card2 && card1 == card3 && card1 == card4 && card1 == card5) {
			System.out.println("You have a flush!");
		} else {
			System.out.println("Close, but no cigar.");
		}
	}
}
