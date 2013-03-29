package lab6;

public class Parabola {
	
	public static void main(String[] args) {
		
		double t = 0.0;
		double tDelta = 0.001;
		
		double vx = 1;
		double vy = 1;
		
		double y = 0.0;
		double x = 0.0;
		
		System.out.println("(" + x + ", " + y + ")");
		
		while ((t <= 10.0) && (y >= 0.0)) {
			t += tDelta;
			x = vx * t;
			y = (-4.9 * (t * t)) + (vy * t);
			
			if (y >= 0.0) {
				System.out.println("(" + x + ", " + y + ")");
			} else {
				System.out.println("(" + (vx * (vy / 4.9)) + ", " + 0.0 + ")");

			}
		}
		
	}
}
