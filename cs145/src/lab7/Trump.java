package lab7;

public class Trump {
	
	public static void main(String[] args) {
		
		Deck deck = new Deck();
		int trump = 0;
		int sameColorAsTrump = 1;
		
		Card card1 = deck.draw();
		Card card2 = deck.draw();
		Card card3 = deck.draw();
		Card card4 = deck.draw();
		Card card5 = deck.draw();
		
		if ((card1.getSuit() == trump) || ((card1.getSuit() == sameColorAsTrump) && (card1.getRank() == 11))) {
			System.out.println("Card 1 is a trump.");
		}
		if ((card2.getSuit() == trump) || ((card2.getSuit() == sameColorAsTrump) && (card2.getRank() == 11))) {
			System.out.println("Card 2 is a trump.");
		}
		if ((card3.getSuit() == trump) || ((card3.getSuit() == sameColorAsTrump) && (card3.getRank() == 11))) {
			System.out.println("Card 3 is a trump.");
		}
		if ((card4.getSuit() == trump) || ((card4.getSuit() == sameColorAsTrump) && (card4.getRank() == 11))) {
			System.out.println("Card 4 is a trump.");
		}
		if ((card5.getSuit() == trump) || ((card5.getSuit() == sameColorAsTrump) && (card5.getRank() == 11))) {
			System.out.println("Card 5 is a trump.");
		}
		
	}
}
