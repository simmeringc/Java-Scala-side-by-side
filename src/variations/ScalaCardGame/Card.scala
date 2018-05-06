/**
  * Created by simmeringc on 1/22/18.
  */

package variations.ScalaCardGame

class Card(suitx: Suits.Value, rankx: Ranks.Value)  {
  var suit: Suits.Value = suitx
  var rank: Ranks.Value = rankx

  override def toString: String = suit + "" + rank + " "
}


