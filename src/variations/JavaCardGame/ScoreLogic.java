/**
 * Created by simmeringc on 1/22/18.
 */

package variations.JavaCardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScoreLogic {

  /**
   * Using a switch case to implement our points system based on char enum symbols.
   */
  public void setScores(List<Player> players) {

    for (Player player : players) {
      int score = 0;

      for (Card card : player.getHand()) {

        String rank = card.getRank().getSymbol();

        switch (rank) {
          case "J": score += 10; break;
          case "Q": score += 10; break;
          case "K": score += 10; break;
          case "A": score += 15; break;
          default:
            score += Integer.parseInt(rank);
        }
      }

      player.setScore(score);
    }
  }

  /**
   * Sort players' scores and compare.
   * Resolve ties and create a ranking.
   */
  public void getPlayerRankings(List<Player> players) {
    System.out.println("scoreboard:");

    setScores(players);

    // If there's only 1 player, return him as the winner
    if (players.size() == 1) {
      Player player = players.get(0);
      System.out.print("\n" + (players.indexOf(player) + 1) + ". " + player.getName() + ", ");
      player.printHand();
      String report = "= " + player.getScore() + " points ** WINNER ** \n";
      System.out.println(report);
      return;
    }

    // Sort players based on score
    Collections.sort(players, new PlayerComparator());
    Collections.reverse(players);

    // Get winning score
    int winningScore = players.get(0).getScore();

    List<Player> winningPlayers = new ArrayList<>();

    // Add winning players to winners list
    // If there's a tie, there will be multiple winners
    for (Player player : players) {
      if (player.getScore() == winningScore) {
        winningPlayers.add(player);
      }
    }

    // If there's a tie, list all tied players first
    if (winningPlayers.size() > 1) {
      for (Player player : players) {
        if (winningPlayers.contains(player)) {
          System.out.print("\n" + (players.indexOf(player) + 1) + ". " + player.getName() + ", ");
          player.printHand();
          System.out.print("= " + player.getScore() + " points ** TIED ** \n");
        }
      }
    }

    // After listing tied players if there are any, list the rest of the player rankings
    // If there are no tied players, the above out put is skipped, and all players are output from here, in order
    for (Player player : players) {
      if (!winningPlayers.contains(player) || winningPlayers.size() == 1) {

        System.out.print("\n" + (players.indexOf(player) + 1) + ". " + player.getName() + ", ");
        player.printHand();
        String report = "= " + player.getScore() + " points";

        if (player == players.get(0)) {
          report += " ** WINNER **";
        }

        report += "\n";

        System.out.print(report);
      }
    }
  }

  // Sorting purely by highest integer score
  public class PlayerComparator implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
      return p1.getScore() > p2.getScore() ? 1 : p1.getScore() < p2.getScore() ? -1 : 0;
    }
  }
}