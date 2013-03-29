package hw4.forstezt;

/**
 * creates a bomb that counts down from a specified time
 * @author Zach
 *
 */
public class Bomb {
	
	private double startTimeMarker;
	private double startingTime;
	
	/**
	 * initializes the bomb with a certain amount of seconds on the clock
	 * @param seconds
	 * the amount of time in seconds that the bomb starts with
	 */
	public Bomb(double seconds) {
		startTimeMarker = System.currentTimeMillis();
		startingTime = seconds;
	}
	
	/**
	 * returns the amount of time left on the bomb
	 * @return
	 */
	public double checkTimeRemaining() {
		return (startingTime - (System.currentTimeMillis() - startTimeMarker) / 1000); 
	}
}
