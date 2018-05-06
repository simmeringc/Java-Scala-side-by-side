/**
  * Created by simmeringc on 1/23/18.
  */

package variations.ScalaCardGame

import scala.collection.mutable.ListBuffer

class ScoreLogic {

  /**
    * Using a match case to implement our points system based on enum rank
    */
  def setScores(players: ListBuffer[Player]) = {

    for (p <- players) {
      var score = 0

      for (c <- p.hand) {
        c.rank match {
          case Ranks.JACK => score += 10
          case Ranks.QUEEN => score += 10
          case Ranks.KING => score += 10
          case Ranks.ACE => score += 15
          case numberCard => score += (Ranks.withName(numberCard.toString).id + 2)
        }
        p.score = score
      }
    }
  }

  /**
    * Sort players' scores and compare.
    * Resolve ties and create a ranking.
    */
  def getPlayerRankings(players: ListBuffer[Player]): Any = {
    println("scoreboard:")

    setScores(players)

    if (players.size == 1) {
      val player = players.head
      print("\n" + (players.indexOf(player) + 1) + ". " + player.name + ", ")
      player.printHand()
      val report = "= " + player.score + " points ** WINNER ** \n"
      println(report)
      return
    }

    // Sort players based on score
    val sortedPlayers = players.sortBy(p => p.score).reverse

    //Get winning score
    val winningScore = sortedPlayers.head.score

    var winningPlayers: ListBuffer[Player] = ListBuffer()

    // Add winning players to winners list
    // If there's a tie, there will be multiple winners
    for (p <- sortedPlayers) {
      if (p.score == winningScore) {
        winningPlayers += p
      }
    }

    // If there's a tie, list all tied players first
    if (winningPlayers.size > 1) {
      for (p <- sortedPlayers) {
        if (winningPlayers.contains(p)) {
          print("\n" + (sortedPlayers.indexOf(p) + 1) + ". " + p.name + ", ")
          p.printHand()
          print ("= " + p.score + " points ** TIED ** \n")
        }
      }
    }

    // After listing tied players if there are any, list the rest of the player rankings
    // If there are no tied players, the above out put is skipped, and all players are output from here, in order
    for (p <- sortedPlayers) {
      if (!winningPlayers.contains(p) || winningPlayers.size == 1) {
        print("\n" + (sortedPlayers.indexOf(p) + 1) + ". " + p.name + ", ")
        p.printHand()
        var report = "= " + p.score + " points"
        if (p eq sortedPlayers(0)) report += " ** WINNER **"
        report += "\n"
        print(report)
      }
    }
  }
}
