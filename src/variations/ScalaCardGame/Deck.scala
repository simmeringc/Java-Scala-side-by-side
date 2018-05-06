/**
  * Created by simmeringc on 1/22/18.
  */

package variations.ScalaCardGame

import scala.collection.mutable.ListBuffer

class Deck {
  var deckCards: ListBuffer[Card] = ListBuffer()
  var dealtCards: ListBuffer[Card] = ListBuffer()

  for (s <- Suits.values) {
    for (r <- Ranks.values) {
      deckCards += new Card(s, r)
    }
  }

  def dealTopCard(player: Player) = {
    val topCard = deckCards.head
    player.hand += topCard
    dealtCards += topCard
    deckCards = deckCards.drop(1)
  }

  def shuffleDeck() = {
    deckCards = scala.util.Random.shuffle(deckCards)
  }

  def printDeck() = {
    for (card <- deckCards) print(card.toString())
  }
}
