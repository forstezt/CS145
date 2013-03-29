package hw4.forstezt;

/**
 * creates a lever that can be thrown on or off
 * starts thrown off
 * @author Zach
 *
 */
public class Lever {
	
	private boolean isThrown;
	
	/**
	 * initializes the lever thrown off
	 */
	public Lever() {
		isThrown = false;
	}
	
	/**
	 * causes the lever to be thrown on
	 */
	public void throwOn() {
		isThrown = true;
	}
	
	/**
	 * causes the lever to be thrown off
	 */
	public void throwOff() {
		isThrown = false;
	}
	
	/**
	 * returns true if the lever is thrown on, false otherwise
	 * @return
	 */
	public boolean isThrown() {
		return isThrown;
	}
}