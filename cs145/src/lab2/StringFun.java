package lab2;

import java.util.Scanner;

public class StringFun {
	public static void main(String[] args) {
		
		//Variables
		String day;
		String month; 
		String year;
		Scanner in = new Scanner(System.in);
		
		
		//Assignments
		month = in.next ();
		day = in.next ();
		year = in.next ();
		
		//Output
		System.out.println(month + " " + day + ", " + year);
	}
}
