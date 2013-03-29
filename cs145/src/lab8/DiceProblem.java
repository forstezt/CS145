package lab8;

import java.util.Random;

public class DiceProblem {
	public static void main(String[] args) {
		Random dice = new Random();
		int[] rollValues = new int[6];
		
		int numberOfRolls = 0;
			
		while (numberOfRolls < 100000) {
			int diceRoll = dice.nextInt(6);
			rollValues[diceRoll]++;
			numberOfRolls++;
		}
		
		System.out.println("1's rolled:  " + rollValues[0]);
		System.out.println("2's rolled:  " + rollValues[1]);
		System.out.println("3's rolled:  " + rollValues[2]);
		System.out.println("4's rolled:  " + rollValues[3]);
		System.out.println("5's rolled:  " + rollValues[4]);
		System.out.println("6's rolled:  " + rollValues[5]);
	}
}
