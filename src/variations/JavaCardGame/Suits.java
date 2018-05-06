/**
 * Created by simmeringc on 1/22/18.
 */

package variations.JavaCardGame;

/**
 * Using enum to take advantage of built in ordinals and symbol mapping.
 */

public enum Suits {

  HEART('\u2661'),
  DIAMOND('\u2662'),
  CLUB('\u2667'),
  SPADE('\u2664');

  private char symbol;

  private Suits(char symbol)
  {
    this.symbol = symbol;
  }

  public char getSymbol()
  {
    return this.symbol;
  }
}