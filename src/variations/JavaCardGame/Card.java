/**
 * Created by simmeringc on 1/22/18.
 */

package variations.JavaCardGame;

public class Card {

  private Suits suit;
  private Ranks rank;

  public Card(Suits suit, Ranks rank) {
    this.suit = suit;
    this.rank = rank;
  }

  public Suits getSuit() {
    return suit;
  }

  public Ranks getRank() {
    return rank;
  }

  @Override
  public String toString() {
    String card = this.getSuit().getSymbol() + "" + this.getRank().getSymbol() + " ";
    System.out.print(card);
    return card;
  }
}
