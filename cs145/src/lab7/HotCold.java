package lab7;

import java.util.Scanner;

public class HotCold {
	
	public static String enterGuess() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Try to guess the rank and suit of the card.");
		System.out.println("Enter your guess in the form:  1 H  or  9 C.");
		
		String guess = in.nextLine();
		
		return guess;
	}
	
	public static int readSuit(String guess) {
		
		Scanner in = new Scanner(guess);
		
		in.next();
		String suitGuess = in.next();
		
		while (!((suitGuess.equals("H")) || (suitGuess.equals("D")) || (suitGuess.equals("S")) || (suitGuess.equals("C")))) {
			enterGuess();
			in = new Scanner(guess);
			in.next();
			suitGuess = in.next();
		}
		
		int suitGuessInt = -1;
		
		if (suitGuess.equals("H")) {
			suitGuessInt = 0;
		} else if (suitGuess.equals("D")) {
			suitGuessInt = 1;
		} else if (suitGuess.equals("S")) {
			suitGuessInt = 2;
		} else if (suitGuess.equals("C")) {
			suitGuessInt = 3;
		}
		
		return suitGuessInt;
	}
	
	public static int readRank(String guess) {
		
		Scanner in = new Scanner(guess);
		
		int rankGuess = in.nextInt();
				
		while (!((rankGuess >= 1) && (rankGuess <= 13))) {		
			enterGuess();
			in = new Scanner(guess);
			rankGuess = in.nextInt();				
		}
		
		return rankGuess;
	}
	
	
	public static boolean checkGuess(int rankGuess, int suitGuessInt, Deck deck, Card card) {
				
		boolean isRight = false;
		
		if (card.getRank() == rankGuess) {
			System.out.println("Congratulations, you guessed the correct rank!");
			if (suitGuessInt == card.getSuit()) {
				System.out.println("Wow, you guessed the correct suit!");
				isRight = true;
			} else {
				System.out.println("Sorry, you guessed the wrong suit.");
			}
		} else if (card.getRank() > rankGuess) {
			System.out.println("You're a bit too low.");
			if (suitGuessInt == card.getSuit()) {
				System.out.println("Wow, you guessed the correct suit!");
			} else {
				System.out.println("Sorry, you guessed the wrong suit.");
			}
		} else if (card.getRank() < rankGuess) {
			System.out.println("You're a bit too high.");
			if (suitGuessInt == card.getSuit()) {
				System.out.println("Wow, you guessed the correct suit!");
			} else {
				System.out.println("Sorry, you guessed the wrong suit.");
			}
		}
		
		return isRight;
	}
	
	
	public static void main(String[] args) {
		
		Deck deck = new Deck();
		Card card = deck.draw();
		
		String guess = enterGuess();
		int rankGuess = readRank(guess);
		int suitGuessInt = readSuit(guess);
		boolean isRight = checkGuess(rankGuess, suitGuessInt, deck, card);
		
		while (isRight == false) {
			
			guess = enterGuess();
			rankGuess = readRank(guess);
			suitGuessInt = readSuit(guess);
			isRight = checkGuess(rankGuess, suitGuessInt, deck, card);		}
	}
}
