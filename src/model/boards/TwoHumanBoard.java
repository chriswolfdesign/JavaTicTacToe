package model.boards;

import factories.PlayerFactory;
import model.players.Player;
import model.players.PlayerOptions;

/**
 * TwoHumanBoard.java
 *
 * <p>A board designed to be played by two human players
 *
 * @author Chris Wolf
 * @version 1.0.0 (December 27, 2019)
 */
public class TwoHumanBoard extends Board {
  /** Constructor */
  public TwoHumanBoard() {
    super();
    Player playerOne = PlayerFactory.generatePlayer(PlayerOptions.HUMAN_PLAYER, "Player One", 'X');
    Player playerTwo = PlayerFactory.generatePlayer(PlayerOptions.HUMAN_PLAYER, "Player Two", 'O');
    this.setPlayerOne(playerOne);
    this.setPlayerTwo(playerTwo);
    this.setCurrentPlayer(this.getPlayerOne());
  }
}
