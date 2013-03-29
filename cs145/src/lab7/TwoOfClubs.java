package lab7;

public class TwoOfClubs {
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		
		String player1 = "";
		String player2 = "";
		String player3 = "";
		String player4 = "";
		
		while (deck.isEmpty() == false) {
			player1 = player1 + " " + deck.draw().toString();
			player2 = player2 + " " + deck.draw().toString();
			player3 = player3 + " " + deck.draw().toString();
			player4 = player4 + " " + deck.draw().toString();
		}
		
		if (player1.contains("2 of clubs")) {
			System.out.println("The two of clubs went to Player 1.");
		} else if (player2.contains("2 of clubs")) {
			System.out.println("The two of clubs went to Player 2.");
		} else if (player3.contains("2 of clubs")) {
			System.out.println("The two of clubs went to Player 3.");
		} else {
			System.out.println("The two of clubs went to Player 4.");
		}
	}
}
