package lab3;

import java.util.Scanner;

public class Number {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Please enter an integral number.");
		String number = in.next();
		System.out.println(number.length() + " digits exist in this number.");
	}
}
