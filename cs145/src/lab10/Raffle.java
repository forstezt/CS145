package lab10;

import java.util.Random;
import java.util.Scanner;

public class Raffle {
	
	private int numberOfNames;
	
	public Raffle(int x) {
		if (x < 0) {
			throw new IllegalArgumentException();
		}
		numberOfNames = x;
	}
	
	private String[] raffleNames = new String[numberOfNames];

	public void addName(String name) {
		for (int i = 0; i < raffleNames.length; i++) {
			if (raffleNames[i].equals(null)) {
				raffleNames[i] = name;
			}
		}
	}
	
	public String drawName() {
		int i = 0;
		while (!raffleNames[i].equals(null)) {	
			i++;
		}
		Random namePicker= new Random(i);
		int nameNumber = namePicker.nextInt();
		String name = raffleNames[nameNumber];
		i = nameNumber;
		while (!raffleNames[i].equals(null)) {
			raffleNames[i - 1] = raffleNames[i];
			raffleNames[i] = null;
			i++;
		}
		raffleNames[nameNumber] = null;
		return name;
	}
	
	public static void main(String[] args) {	
		Raffle raffle = new Raffle(5);
		raffle.addName("John");
		raffle.addName("Bill");
		raffle.addName("Cody");
		
		System.out.println("The winner is: " + raffle.drawName());

	}
}
