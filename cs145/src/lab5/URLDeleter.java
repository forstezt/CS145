package lab5;

import java.util.Scanner;

public class URLDeleter {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			String possibleURL = in.next();
			if (possibleURL.startsWith("http://")) {
				System.out.println(possibleURL);
			}
		}
	}
}
