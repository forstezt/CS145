package lab3;

import java.util.Random;
import java.util.Scanner;

public class Flashcard {

	public static boolean numberChecker() {
		Random generator1 = new Random();
		int number1 = generator1.nextInt(11);
		System.out.println("First Number:  " + number1);

		Random generator2 = new Random();
		int number2 = generator2.nextInt(11);
		System.out.println("Second Number:  " + number2);

		System.out.println("Please multiply these two numbers together and enter the result on the next line.");

		Scanner in = new Scanner(System.in);
		int product = in.nextInt();

		int actualProduct = number1 * number2;
		if (product == actualProduct) {
			System.out.println("Good job!  Your answer is correct.");
			return true;
		} else {
			System.out.println("Unfortunately, you are wrong.");
			return false;
		}
	}
	
	public static void main(String[] args) {
		
		int score = 0;
		for (int i = 1; i < 11; i+=0) {
			boolean isTrue = numberChecker();
			if (isTrue) {
				score = score + 1;
			}
			
			System.out.println("Score:  " + score);
			System.out.println();
		}
		}
	}
