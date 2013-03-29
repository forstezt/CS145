package prefinal;

public class APLine {
	private int a;
	private int b;
	private int c;
	
	public APLine(int num1, int num2, int num3) {
		a = num1;
		b = num2;
		c = num3;
	}
	
	public double getSlope() {
		return -a / (double)b;
	}
	
	public boolean isOnLine(int xCoordinate, int yCoordinate) {
		return (a * xCoordinate + b * yCoordinate + c) == 0;
	}
	
	public static void main(String[] args) {
		APLine line1 = new APLine(5, 4, -17);
		double slope1 = line1.getSlope();
		boolean onLine1 = line1.isOnLine(5, -2);
		
		System.out.println(slope1 + "" + onLine1);
	}
}
