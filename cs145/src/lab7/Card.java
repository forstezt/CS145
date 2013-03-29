package lab7;
public class Card {
  public static int ACE = 1;
  public static int JACK = 11;
  public static int QUEEN = 12;
  public static int KING = 13;
 
  public static int HEARTS = 0;
  public static int DIAMONDS = 1;
  public static int SPADES = 2;
  public static int CLUBS = 3;

  /** Card's suit */
  private int suit;

  /** Card's rank */
  private int rank;
 
  /**
   * Creates a new card.
   * @param suit Card's suit
   * @param rank Card's rank
   */
  public Card(int suit, int rank) {
    this.suit = suit;
    this.rank = rank;
  }
 
  /**
   * Gets the card's rank.
   * @return One of ACE, JACK, QUEEN, KING, and 2-10.
   */
  public int getRank() {
    return rank;
  }
 
  /**
   * Gets the card's suit.
   * @return One of HEARTS, DIAMONDS, SPADES, and CLUBS.
   */
  public int getSuit() {
    return suit;
  }
 
  /**
   * Gets a string representation of this card.
   * @return Text description of card, e.g., "queen of spades."
   */
  public String toString() {
    String suitName;
    if (suit == HEARTS) {
      suitName = "hearts";
    } else if (suit == DIAMONDS) {
      suitName = "diamonds";
    } else if (suit == SPADES) {
      suitName = "spades";
    } else {
      suitName = "clubs";
    }
    
    String rankName;
    if (rank == ACE) {
      rankName = "ace";
    } else if (rank == KING) {
      rankName = "king";
    } else if (rank == QUEEN) {
      rankName = "queen";
    } else if (rank == JACK) {
      rankName = "jack";
    } else {
      rankName = "" + rank;
    }
    
    return rankName + " of " + suitName;
  }
}