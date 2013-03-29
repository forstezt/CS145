package hw4.forstezt;

/**
 * creates a gun that can be picked up and shot
 * starts with a given number of bullets and on the ground
 * @author Zach
 *
 */
public class Gun {
	
	private boolean isPickedUp;
	private boolean isEmpty;
	private int numberOfBullets;
	
	/**
	 * initializes the gun not picked up and with a given number of bullets
	 * @param bullets
	 * the number of bullets with which the gun starts with
	 */
	public Gun(int bullets) {
		isPickedUp = false;
		isEmpty = false;
		numberOfBullets = bullets;
	}
	
	/**
	 * causes the gun to be picked up
	 */
	public void grab() {
		isPickedUp = true;
	}
	
	/**
	 * returns true is the gun is picked up, false otherwise
	 * @return
	 */
	public boolean isPickedUp() {
		return isPickedUp;
	}
	
	/**
	 * returns the number of bullets in the gun
	 * @return
	 */
	public int numberOfBullets() {
		return numberOfBullets;
	}
	
	/**
	 * causes the gun to shoot
	 * subtracts one bullet from the magazine
	 */
	public void shoot() {
		numberOfBullets -= 1;
	}
}
