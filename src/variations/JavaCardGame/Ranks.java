/**
 * Created by simmeringc on 1/22/18.
 */

package variations.JavaCardGame;

/**
 * Using enum to take advantage of built in ordinals and symbol mapping.
 */

public enum Ranks {

  ACE("A"),
  KING("K"),
  QUEEN("Q"),
  JACK("J"),
  TEN("10"),
  NINE("9"),
  EIGHT("8"),
  SEVEN("7"),
  SIX("6"),
  FIVE("5"),
  FOUR("4"),
  THREE("3"),
  TWO("2");

  private String symbol;

  private Ranks(String symbol)
  {
    this.symbol = symbol;
  }

  public String getSymbol()
  {
    return this.symbol;
  }
}
