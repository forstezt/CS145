package hw4.forstezt;

/**
 * creates a mysterious assailant that can enter an area or die
 * the assailant is created alive outside of the given area
 * @author Zach
 *
 */
public class Assailant {
	
	private boolean isAlive;
	private boolean isInside;
	
	/**
	 * initializes the assailant alive and outside
	 */
	public Assailant() {
		isAlive = true;
		isInside = false;
	}
	
	/**
	 * causes the assailant to die
	 */
	public void die() {
		isAlive = false;
	}
	
	/**
	 * returns true if the assailant is alive, false otherwise
	 * @return
	 */
	public boolean isAlive() {
		return isAlive;
	}
	
	/**
	 * causes the assailant to enter an area
	 */
	public void enter() {
		isInside = true;
	}
	
	/**
	 * returns true is the assailant is inside of an area, false otherwise
	 * @return
	 */
	public boolean isInside() {
		return isInside;
	}
}
