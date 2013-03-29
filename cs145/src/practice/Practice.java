package practice;

import hw4.forstezt.Bear;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Scanner;

public class Practice {
	public static void main(String[] args) throws AWTException, InterruptedException {
		//String s = "a,b,c,d,e,f,g";
		//String delimiter = ",";
		//String[] splitString = split(s, delimiter);
		//for (int i = 0; i < splitString.length; i++) {
		//	System.out.println(splitString[i]);
		//}
		
//		moveMouse();
//		double x = 2.3;
//		double y = 3.2;
//		System.out.printf("hi, i like the numbers %-4.1f and %-4.1f", x, y);
		
		
//		double startTime = System.currentTimeMillis();
//		Scanner in = new Scanner(System.in);
//		String timeWaster = in.next();
//		System.out.println(System.currentTimeMillis() - startTime);
		
		String s = "hello";
		String y = new String("hello");
		
		System.out.println(s == y);
	}
	
	
	public static String[] split(String s, String delimiter) {
		Scanner in = new Scanner(s);
		in.useDelimiter(delimiter);
		int numberOfStrings = 0;
		while (in.hasNext()) {
			in.next();
			numberOfStrings++;
		}
		in.close();
		String[] splitString = new String[numberOfStrings];
		Scanner toArray = new Scanner(s);
		toArray.useDelimiter(delimiter);
		for (int i = 0; i < splitString.length; i++) {
			splitString[i] = toArray.next();
		}
		return splitString;
	}
	
	public static void moveMouse() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		
		int x = 500;
		int y = 500;
		
		for (int i = 0; i < 1; i++) {
			robot.mouseMove(x, y);
			Thread.currentThread().sleep(1000);
			robot.mouseMove(x + 100, y);
			Thread.currentThread().sleep(1000);
			robot.mouseMove(x + 100, y - 100);
			Thread.currentThread().sleep(1000);
			robot.mouseMove(x, y - 100);
			Thread.currentThread().sleep(1000);
		}
		
	}
}
