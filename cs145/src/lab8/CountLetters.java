package lab8;

public class CountLetters {
	public static void main(String[] args) {
		String string = "thisisastring";
		int[] letters = new int[26];
		
		int letterNumber;
		for (int i = 0; i < string.length(); i++) {
			letterNumber = string.charAt(i) - 'a';
			letters[letterNumber]++;
		}
		

		for (int i = 0; i < letters.length; i++) {
			if (letters[i] != 0) {				
				System.out.println("Occurences of the letter " + ((char)('a' + i)) + ":  " + letters[i]);
			}
		}
	}
}
