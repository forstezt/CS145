package pre2;

import java.util.Scanner;

public class Password {
	public static boolean isTrivial(String password) {
		boolean isTrivial = false;
		
		if (password.equals("password") || password.equals("")) {
			isTrivial = true;
		}
		
		return isTrivial;
		
	}
	
	public static boolean containsUpper(String password) {
		boolean isUpperCase = false;
		
		for (int i = 0; i < password.length(); i++) {
			char character = password.charAt(i);
			if (Character.isUpperCase(character)) {
				isUpperCase = true;
			}
		}
		
		return isUpperCase;
	}

	public static boolean containsDigit(String password) {
		boolean containsDigit = false;
		
		for (int i = 0; i < password.length(); i++) {
			char character = password.charAt(i);
			if (Character.isDigit(character)) {
				containsDigit = true;
			}
		}
		
		return containsDigit;
	}
	
	public static boolean containsNonAlphanumeric(String password) {
		boolean containsNonAlphanumeric = false;
		
		for(int i = 0; i < password.length(); i++) {
			char character = password.charAt(i);
			if (!(Character.isDigit(character) || Character.isLetter(character))) {
				containsNonAlphanumeric = true;
			}
		}
		
		return containsNonAlphanumeric;
	}
	
	public static boolean containsWhitespace(String password) {
		boolean containsWhitespace = false;
		
		for (int i = 0; i < password.length(); i++) {
			char character = password.charAt(i);
			if ((character == ' ') || (character == '\n') || (character == '\t')) {
				containsWhitespace = true;
			}
		}
		
		return containsWhitespace;
	}
	
	public static boolean containsAt(String password) {
		boolean containsAt = false;
		
		for (int i = 0; i < password.length(); i++) {
			char character = password.charAt(i);
			if (character == '@') {
				containsAt = true;
			}
		}
		
		return containsAt;
	}
	
	public static boolean isLegal(String password) {
		boolean isLegal = false;
		
		boolean isTrivial = isTrivial(password);
		boolean isUpperCase = containsUpper(password);
		boolean containsDigit = containsDigit(password);
		boolean containsNonAlphanumeric = containsNonAlphanumeric(password);
		boolean containsWhitespace = containsWhitespace(password);
		boolean containsAt = containsAt(password);
		
		if ((isTrivial == false) && (isUpperCase == true) && (containsDigit == true) && (containsNonAlphanumeric == true) && (containsWhitespace == false) && (containsAt == false)) {
			isLegal = true;
		}
		return isLegal;
	}
	
	public static void main(String[] args) {
		System.out.println("Please enter your password.");
		
		Scanner in = new Scanner(System.in);
		String password = in.next();
		
		boolean isLegal = false;
		
		while (isLegal == false) {
			isLegal = isLegal(password);
			
			if (isLegal == true) {
				System.out.println("Your password is valid.");
			} else {
				System.out.println("Sorry, the password you entered is not valid.  Please enter a new password.");
				password = in.next();
				
			}
		}
		
	}
}
