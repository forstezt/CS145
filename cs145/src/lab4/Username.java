package lab4;

import java.util.Scanner;

public class Username {
	
	public static String composeUsername(String lastName, String firstName) {
		
		String username = firstName.toLowerCase().charAt(0) + lastName.toLowerCase();
		return username;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter your last name.");
		String lastName = in.next();
		
		System.out.println("Please enter your first name.");
		String firstName = in.next();
		
		String username = composeUsername(lastName, firstName);
		
		System.out.println("Username:  " + username);
	}
}
