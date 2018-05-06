/**
  * Created by simmeringc on 1/22/18.
  */

package variations.ScalaCardGame

import scala.collection.mutable.ListBuffer

class Player(namex: String) {
  var name: String = namex
  var score: Int = 0
  var hand: ListBuffer[Card] = ListBuffer()

  def printHand() = {
    for (card <- hand) print(card.toString())
  }

  /**
    * Wow, this is much cleaner than my Java implementation.
    *
    * Sort hand by suit, then by point value.
    * Highest value cards to appear first in the hand.
    *
    * Suit Order: Hearts, Diamonds, Clubs then Spades.
    * All number cards equal their numbers, face cards equal 10 points, Aces are 15 points.
    * In this Scala implementation, face cards remain ordered.
   */
  def sortHand() = {
    hand = hand.sortBy(c => (c.suit, c.rank))
  }
}
