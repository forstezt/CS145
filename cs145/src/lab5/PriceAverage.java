package lab5;

import java.util.Scanner;

public class PriceAverage {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		double total = 0;
		int numberOfNumbers = 0;

		
		while (in.hasNextDouble()) {
			double number = in.nextDouble();
			total = total + number;
			numberOfNumbers = numberOfNumbers + 1;
		}
		
		double average = total / numberOfNumbers;

		System.out.println("Average of prices:  " + average);
	}
}
