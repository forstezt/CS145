package lab4;

import java.util.Random;

public class Asterisks {
	
	public static String getStatusBar(int numberOfAsterisks) {
		
		String asterisks = "";
		String asterick = "*";
		for (int i = 1; i < (numberOfAsterisks + 1); i++) {
			asterisks += asterick;
		}
		
		return asterisks;
	}
	
	public static void main(String[] args) {
		
		Random generator = new Random();
		
		int numberOfAsterisks = generator.nextInt(101);
		
		String asterisks = getStatusBar(numberOfAsterisks);
		
		System.out.println("Number:  " + numberOfAsterisks);
		System.out.println(asterisks);
	}
}
