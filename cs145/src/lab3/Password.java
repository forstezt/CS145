package lab3;

import java.util.Scanner;

public class Password {

	public static void main(String[] args) {

		System.out.println("Please enter your password on the next line.");
		Scanner in = new Scanner(System.in);
		String password = in.next();

		System.out.println("Please reenter your password.");
		String passwordCheck = in.next();

		if (password.equals(passwordCheck)) {
			System.out.println("Password Accepted!");
		} else {
			System.out.println("Passwords do not match.");
		}

	}
}
