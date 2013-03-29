package lab5;

import java.util.Scanner;
import java.text.*;

public class CircleCoordinates {
	public static void main(String[] args) {
		
		DecimalFormat decimals = new DecimalFormat("#.##");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int i = 0;
		
		while (i < n) {
			
			double angle = (360.0 / n) * i;
			
			angle = Math.toRadians(angle);
					
			double x = Math.cos(angle);
			double y = Math.sin(angle);
			
			System.out.println("(" + decimals.format(x) + "," + decimals.format(y) + ")");
			i = i + 1;
		}
	}
}
