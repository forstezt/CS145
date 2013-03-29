package lab6;

import java.util.Random;

public class DiceRoll {
	
	public static void main(String[] args) {
		
		Random dice = new Random();
		
		int numberOfRolls = 0;
		int oneCount = 0;
		int twoCount = 0;
		int threeCount = 0;
		int fourCount = 0;
		int fiveCount = 0;
		int sixCount = 0;

		
		while (numberOfRolls < 100000) {
			
			numberOfRolls++;
			int diceRoll = dice.nextInt(7);
			
			if (diceRoll == 1) {
				oneCount++;
			} else if (diceRoll == 2) {
				twoCount++;

			} else if (diceRoll == 3) {
				threeCount++;

			} else if (diceRoll == 4) {
				fourCount++;

			} else if (diceRoll == 5) {
				fiveCount++;

			} else if (diceRoll == 6) {
				sixCount++;

			}
			
		}
		System.out.println("1's rolled:  " + oneCount);
		System.out.println("2's rolled:  " + twoCount);
		System.out.println("3's rolled:  " + threeCount);
		System.out.println("4's rolled:  " + fourCount);
		System.out.println("5's rolled:  " + fiveCount);
		System.out.println("6's rolled:  " + sixCount);

	}
}
