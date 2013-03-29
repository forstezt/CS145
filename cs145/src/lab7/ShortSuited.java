package lab7;

public class ShortSuited {
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		
		int card1 = deck.draw().getSuit();
		int card2 = deck.draw().getSuit();
		int card3 = deck.draw().getSuit();
		int card4 = deck.draw().getSuit();
		int card5 = deck.draw().getSuit();
		
		
		String allSuits = "" + card1 + card2 + card3 + card4 + card5;
		
		if (!allSuits.contains("0")) {
			System.out.println("These cards contain no hearts.");
		}
		if (!allSuits.contains("1")) {
			System.out.println("These cards contain no diamonds.");
		}
		if (!allSuits.contains("2")) {
			System.out.println("These cards contain no spades.");
		}
		if (!allSuits.contains("3")) {
			System.out.println("These cards contain no clubs.");
		}
		
		if (allSuits.contains("0") && allSuits.contains("1") && allSuits.contains("2") && allSuits.contains("3")) {
			System.out.println("All suits are accounted for.");
		}
	}
}
