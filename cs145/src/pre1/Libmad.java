package pre1;

import java.util.Scanner;

public class Libmad {
	public static void main(String[] args) {
		
		//Variables Declared
		String word1;
		String word2;
		String word3;
		String word4;
		String word5;
		String word6;
		String word7;
		String word8;
		String word9;
		String word10;
		
		Scanner in = new Scanner(System.in);
		
		//Asks for words
		System.out.println("Verb:  ");
		word1 = in.next ();
		
		System.out.println("Ing-Verb:  ");
		word2 = in.next ();
		
		System.out.println("Adjective:  ");
		word3 = in.next ();
		
		System.out.println("Adjective:  ");
		word4 = in.next ();
		
		System.out.println("Noun:  ");
		word5 = in.next ();
		
		System.out.println("Adjective:  ");
		word6 = in.next ();
		
		System.out.println("Plural Noun:  ");
		word7 = in.next ();
		
		System.out.println("Adjective:  ");
		word8 = in.next ();
		
		System.out.println("Noun:  ");
		word9 = in.next ();
		
		System.out.println("Plural Noun:  ");
		word10 = in.next ();
		
		//Change Words to Lower Case
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		word3 = word3.toLowerCase();
		word4 = word4.toLowerCase();
		word5 = word5.toLowerCase();
		word6 = word6.toLowerCase();
		word7 = word7.toLowerCase();
		word8 = word8.toLowerCase();
		word9 = word9.toLowerCase();
		word10 = word10.toLowerCase();
		
		//Final Output
		System.out.println("Your primary goal in this homework is to " + word1 +  " yourself with " + word2 + " your " + word3 + " " + word4 + " " + word5 + " in Java. In this case, your " + word6 + " " + word7 + " are fairly " + word8 + " -- you long for a " + word9 + ".  As you implement this dream, you will learn about the indispensable " + word10 + ".");
	}
}
