/**
  * Created by simmeringc on 1/22/18.
  */

package variations.ScalaCardGame

import scala.collection.mutable.ListBuffer

object GameDriver extends App {

  // Create players
  var players: ListBuffer[Player] = ListBuffer()
  players += new Player("Scalawag1")
  players += new Player("Scalawag2")
  players += new Player("Scalawag3")
  players += new Player("Scalawag4")
  players += new Player("Scalawag5")

  // Create and shuffle deck
  var deck = new Deck
  deck.shuffleDeck()

  println("dealing cards...\n")

  // Deal cards round robin style
  for (i <- 1 to 5) {
    for (p <- players) {
      deck.dealTopCard(p)
    }
  }

  // Sort player hands to prepare output
  for (p <- players) {
    p.sortHand()
  }

  // Show scoreboard
  var scoreLogic = new ScoreLogic
  scoreLogic.getPlayerRankings(players)
}
