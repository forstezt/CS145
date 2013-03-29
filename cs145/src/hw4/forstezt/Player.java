package hw4.forstezt;

/**
 * creates a player that has a name and a gender, specified by the user
 * @author Zach
 *
 */
public class Player {
  private String name;
  private boolean isFemale;

  /**
   * initializes the player's name and gender
   * @param name
   * a name for the player
   * @param isFemale
   * whether or not the player is a female
   */
  public Player(String name,
                boolean isFemale) {
    this.name = name;
    this.isFemale = isFemale;
  }

 /**
  * returns the name of the player as a string
  * @return
  */
  public String getName() {
    return name;
  }

  /**
   * returns true if the player is female, false otherwise
   * @return
   */
  public boolean isFemale() {
    return isFemale;
  }
}