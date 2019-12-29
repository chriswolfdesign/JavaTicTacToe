package main;

import factories.GameFactory;
import model.games.Game;
import model.games.GameOptions;

/**
 * Driver.java
 *
 * <p>Entry point for our Tic-Tac-Toe game
 *
 * @author Chris Wolf
 * @version 1.0.0 (December 27, 2019)
 */
public class Driver {
  /**
   * Entry point for our Tic-Tac-Toe game
   *
   * @param args no command line arguments
   */
  public static void main(String[] args) {
    Game game = GameFactory.generateGame(GameOptions.CLI);
    game.run();
  }
}
