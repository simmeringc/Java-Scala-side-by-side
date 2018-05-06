/**
 * Created by simmeringc on 1/22/18.
 */

package variations.JavaCardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

  private List<Card> deckCards = new ArrayList<>();
  private List<Card> dealtCards = new ArrayList<>();

  public Deck() {
    for (Suits s : Suits.values()) {
      for (Ranks r : Ranks.values()) {
        Card c = new Card(s, r);
        this.deckCards.add(c);
      }
    }
  }

  public void dealTopCard(Player player) {
    Card card = deckCards.get(0);
    deckCards.remove(0);
    dealtCards.add(card);
    player.getHand().add(card);
  }

  // Storing cards in a Collection in order to
  // take advantage of Collections' built in shuffle method.
  public void shuffleDeck() {
    Collections.shuffle(this.deckCards);
  }

  @Override
  public String toString() {
    for (Card card : deckCards) {
      card.toString();
    }
    return null;
  }
}