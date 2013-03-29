package lab7;

public class War {
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		
		int playerAScore = 0;
		int playerBScore = 0;
		
		while (deck.isEmpty() == false) {
			
			int playerACard = deck.draw().getRank();
			int playerBCard = deck.draw().getRank();
			
			if (playerACard > playerBCard) {
				playerAScore++;
			} else if (playerACard < playerBCard) {
				playerBScore++;
			}
		}
		
		System.out.println("Player A:  " + playerAScore);
		System.out.println("Player B:  " + playerBScore);
		
		if (playerAScore > playerBScore) {
			System.out.println("Player A wins!");
		} else if (playerBScore > playerAScore) {
			System.out.println("Player b wins!");
		} else {
			System.out.println("It's a tie!");
		}
	}
}
