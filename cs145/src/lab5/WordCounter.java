package lab5;

import java.util.Scanner;
public class WordCounter {
	
	public static int countWordsInString(Scanner in) {
		int wordCount = 0;
		
		while (in.hasNext()) {
			String string = in.next();
			wordCount = wordCount + 1;
		}
		
		System.out.println(wordCount);
		
		return wordCount;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int wordCount = countWordsInString(in);
		System.out.println("Number of words in string:  " + wordCount);
	}
}
