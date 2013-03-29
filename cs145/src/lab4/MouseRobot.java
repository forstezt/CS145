package lab4;


import java.awt.AWTException;
import java.awt.Robot;
import java.util.Scanner;


public class MouseRobot {
	
	public static void main(String[] args) throws AWTException {
		Robot robot = new Robot();
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter an X coordinate.");
		int x = in.nextInt();
		
		System.out.println("Enter a Y coordinate.");
		int y = in.nextInt();
		
		robot.mouseMove(x, y);
	}
}
