package factories;

import model.players.HumanPlayer;
import model.players.Player;
import model.players.PlayerOptions;

/**
 * PlayerFactory.java
 *
 * <p>Generates the appropriate player based on input
 *
 * @author Chris Wolf
 * @version 1.0.0 (December 27, 2019)
 */
public class PlayerFactory {
  /**
   * Generates the appropriate player
   *
   * @param choice the type of player needed for the game
   * @param name the player's name
   * @param representation the way the player will be displayed on the board (X/O)
   * @return the appropriate player
   */
  public static Player generatePlayer(PlayerOptions choice, String name, char representation) {
    switch (choice) {
      case HUMAN_PLAYER:
        return new HumanPlayer(name, representation);
      default:
        return null;
    }
  }
}
