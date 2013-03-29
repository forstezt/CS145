package lab10;

public class Interval {
	
	private int min;
	private int max;
	
	public Interval(int x, int y) {
		if (x > y) {
			throw new IllegalArgumentException();
		}
		
		min = x;
		max = y;
	}
	
	public void addNumber(int number) {
		min += number;
		max += number;
	}
	
	public void addInterval(Interval other) {
		min += other.min;
		max += other.max;
	}
	
	public void multiplyIntervals(Interval other) {
		int[] products = {min * other.min, min * other.max, max * other.min, max * other.max};
		min = products[0];
		max = products[3];
		for (int i = 0; i < products.length; i++) {
			if (products[i] < min) {
				min = products[i];
			}
			
			if (products[i] > max) {
				max = products[i];
			}
		}
	}
	
	public String toString() {
		return "(" + min + ", " + max + ")";
	}
	
	public static void main(String[] args) {
		Interval interval1 = new Interval(-2, 4);
		Interval interval2 = new Interval(-1, 3);

		interval1.addNumber(3);
		interval1.addInterval(interval2);
		interval1.multiplyIntervals(interval2);
		
		System.out.println(interval1.toString());
		
	}
}
