package lab4;

import java.util.Scanner;

public class Triangle {
	
	public static double getTriangleArea(double base, double height) {
		
		System.out.println(base + " " +  height);
		
		double area = (0.5) * base * height;
		
		return area;
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the base of a triangle.");
		double base = in.nextDouble();
		
		System.out.println("Please enter the height of a triangle.");
		double height = in.nextDouble();
		
		double area = getTriangleArea(base, height);
		
		System.out.println("The area of your triangle is:  " + area);
	}
}
