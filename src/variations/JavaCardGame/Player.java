/**
 * Created by simmeringc on 1/22/18.
 */

package variations.JavaCardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Player {

  private String name;
  private int score;
  private List<Card> hand = new ArrayList<>();

  public Player(String name) {
    this.name = name;
    this.score = 0;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public int getScore() {
    return score;
  }

  public String getName() {
    return name;
  }

  public List<Card> getHand() {
    return hand;
  }

  public void printHand() {
    for (Card card : hand) {
      card.toString();
    }
  }

  public void sortHand() {
    Collections.sort(this.hand, new HandComparator());
  }

  /**
   * Sort hand by suit, then by point value.
   * Highest value cards to appear first in the hand.
   *
   * Suit Order: Hearts, Diamonds, Clubs then Spades.
   * All number cards equal their numbers, face cards equal 10 points, Aces are 15 points
   * This means that face cards will be unordered among themselves
   */
  public class HandComparator implements Comparator<Card> {

    @Override
    public int compare(Card c1, Card c2) {
      if (c1.getSuit().ordinal() > c2.getSuit().ordinal()) {
        return 1;
      }
      else if (c1.getSuit().ordinal() == c2.getSuit().ordinal()) {
        if ((c1.getRank().getSymbol().equals("J")) && (c2.getRank().getSymbol().equals("J"))) {
          return 0;
        } else if ((c1.getRank().getSymbol().equals("Q")) && (c2.getRank().getSymbol().equals("Q"))) {
          return 0;
        }
        if ((c1.getRank().getSymbol().equals("K")) && (c2.getRank().getSymbol().equals("K"))) {
          return 0;
        } else {
          return c1.getRank().ordinal() > c2.getRank().ordinal() ? 1 :
            c1.getRank().ordinal() < c2.getRank().ordinal() ? -1 : 0;
        }
      } else {
        return -1;
      }
    }
  }
}
