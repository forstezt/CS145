package lab5;

import java.util.Scanner;

public class SeparateNames {
	
	public static void nameSeperator(Scanner in) {
		String nameString = in.next();
		Scanner delimit = new Scanner(nameString);
		delimit.useDelimiter(",");
		
		while (delimit.hasNext()) {
			String name = delimit.next();
			System.out.print(name + "\t");
		}

	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		nameSeperator(in);
	}
}
