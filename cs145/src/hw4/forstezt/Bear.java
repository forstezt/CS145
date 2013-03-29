package hw4.forstezt;

/**
 * creates a bear that can wake up, go to sleep, or die
 * the bear is created asleep and alive
 * @author Zach
 *
 */
public class Bear {
	
	private boolean isAwake;
	private boolean isAlive;
	
	/**
	 * initializes the bear asleep and alive
	 */
	public Bear() {
		isAwake = false;
		isAlive = true;
	}
	
	/**
	 * causes the bear to wake up
	 */
	public void wakeUp() {
		isAwake = true;
	}
	
	/**
	 * causes the bear to go to sleep
	 */
	public void goToSleep() {
		isAwake = false;
	}
	
	/**
	 * returns true is the bear is awake, false otherwise
	 * @return
	 */
	public boolean isAwake() {
		return isAwake;
	}
	
	/**
	 * causes the bear to die
	 */
	public void die() {
		isAlive = false;
	}
	
	/**
	 * returns true is the bear is alive, false otherwise
	 * @return
	 */
	public boolean isAlive() {
		return isAlive;
	}
}
