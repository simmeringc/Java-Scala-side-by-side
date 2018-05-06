/**
 * Created by simmeringc on 1/22/18.
 */

package variations.JavaCardGame;

import java.util.ArrayList;
import java.util.List;

public class GameDriver {

  public static void main(String[] args) {

    // Create players
    List<Player> players = new ArrayList<>();
    players.add(new Player("Tormund Giantsbane"));
    players.add(new Player("John Johnington"));
    players.add(new Player("Reginald Randalson"));
    players.add(new Player("Oscar McFlosscar"));
    players.add(new Player("Katey Simmering"));

    // Create & shuffle deck
    Deck deck = new Deck();
    deck.shuffleDeck();

    System.out.println("dealing cards...\n");

    // Deal cards round robin style
    for (int i = 0; i < 5; i ++) {
      for (Player player : players) {
        deck.dealTopCard(player);
      }
    }

    // Sort player hands to prepare output
    for (Player player : players) {
      player.sortHand();
    }

    // Show scoreboard
    new ScoreLogic().getPlayerRankings(players);
  }
}