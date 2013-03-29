package lab3;

import java.util.Scanner;

public class Filename {

	public static void main(String[] args) {

		String filename;
		Scanner in = new Scanner(System.in);
		char oldChar = ' ';
		char newChar = '_';

		System.out.println("Please enter a filename on the line below.");
		filename = in.nextLine();

		System.out.println(filename.replace(oldChar, newChar));

	}
}
