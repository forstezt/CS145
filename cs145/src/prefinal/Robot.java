package prefinal;

public class Robot {
	private int[] hall;
	private int pos;
	private boolean facingRight;
	
	public Robot(int[] items, int start, boolean right) {
		facingRight = right;
		pos = start;
		hall = new int[items.length];
		for (int i = 0; i < hall.length; i++) {
			hall[i] = items[i];
		}
	}
	
	public int[] getHall() {
		return hall;
	}
	
	public int getPos() {
		return pos;
	}
	
	public boolean getFacingRight() {
		return facingRight;
	}
	
	public boolean forwardMoveBlocked() {
		return ((facingRight && pos == hall.length - 1) || (!facingRight && pos == 0));
	}
	
	public void move() {
		if (hall[pos] > 0) {
			hall[pos] -= 1;
		}
		
		if (hall[pos] == 0) {
			if (!forwardMoveBlocked()) {
				if (facingRight) {
					pos++;
				} else {
					pos--;
				}
			} else {
				facingRight = !facingRight;
			}
		}
	}
	
	public int clearHall() {
		int counter = 0;
		while (!hallIsClear()) {
			move();
			counter++;
		}
		
		return counter;
	}
	
	public boolean hallIsClear() {
		int sum = 0;
		for (int i = 0; i < hall.length; i++) {
			sum += hall[i];
		}
		
		return (sum == 0);
	}
}
