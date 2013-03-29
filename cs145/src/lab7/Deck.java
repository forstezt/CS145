package lab7;
import java.util.Collections;
import java.util.Stack;

public class Deck {
  /** Set of cards in deck */
  private Stack<Card> cards;
 
  /**
   * Creates a new shuffled deck.
   */
  public Deck() {
    cards = new Stack<Card>();
    for (int s = 0; s < 4; ++s) {
      for (int r = Card.ACE; r <= Card.KING; ++r) {
        cards.push(new Card(s, r));
      }
    }
    Collections.shuffle(cards);
  }

  /**
   * Checks whether or not the deck is empty.
   * @return True if empty, false otherwise.
   */
  public boolean isEmpty() {
    return cards.isEmpty();
  }
 
  /**
   * Draws a card. Assumes at least one card is left in deck.
   * @return Card drawn
   */
  public Card draw() {
    return cards.pop();
  }
}