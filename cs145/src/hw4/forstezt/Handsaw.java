package hw4.forstezt;

/**
 * creates a handsaw that can be picked up or broken
 * starts not picked up and not broken
 * @author Zach
 *
 */
public class Handsaw {

	private boolean isPickedUp;
	private boolean isBroken;
	
	/**
	 * initializes the handsaw not picked up and in tact
	 */
	public Handsaw() {
		isPickedUp = false;
		isBroken = false;
	}
	
	/**
	 * causes the gun to be picked up
	 */
	public void grab() {
		isPickedUp = true;
	}
	
	/**
	 * returns true if the gun is picked up, false otherwise
	 * @return
	 */
	public boolean isPickedUp() {
		return isPickedUp;
	}
	
	/**
	 * causes the handsaw to be broken
	 */
	public void breakHandsaw() {
		isBroken = true;
	}
	
	/**
	 * returns true if the handsaw is broken, false otherwise
	 * @return
	 */
	public boolean isBroken() {
		return isBroken;
	}
}
