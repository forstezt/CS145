package lab10;

public class Vector {
	private double ax;
	private double ay;
	private double az;
	
	public Vector(double x, double y, double z) {
		ax = x;
		ay = y;
		az = z;
	}
	
	public double getLength() {
		double vectorLength = Math.sqrt(ax * ax + ay * ay + az * az);
		return vectorLength;
	}
	
	public void addVector(Vector other) {
		ax += other.ax;
		ay += other.ay;
		az += other.az;
	}
	
	public void normalize() {
		double vectorLength = getLength();
		ax /= vectorLength;
		ay /= vectorLength;
		az /= vectorLength;
	}
	
	public double dotProduct(Vector other) {
		return ax * other.ax + ay * other.ay + az * other.az;
	}
	
	public String toString() {
		return "(" + ax + ", " + ay + ", " + az + ")";
	}
	
	public static void main(String[] args) {
		Vector vector1 = new Vector(2, 3, 4);
		Vector vector2 = new Vector(3, 5, 7);
		
		double dotProduct = vector1.dotProduct(vector2);
		
		vector1.addVector(vector2);
		vector1.normalize();
		
		System.out.println("Dot Product = " + dotProduct);
		System.out.println(vector1.toString());
	}
}
