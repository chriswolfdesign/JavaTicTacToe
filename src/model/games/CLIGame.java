package model.games;

import factories.BoardFactory;
import model.boards.Board;
import model.boards.BoardOptions;

/**
 * CLIGame.java
 *
 * <p>A version of this game to be played on the command line
 *
 * @author Chris Wolf
 * @version 1.0.0 (December 27, 2019)
 */
public class CLIGame implements Game {
  /** the board this game will be played on */
  private Board board;

  /** Constructor */
  public CLIGame() {
    this.board = BoardFactory.generateBoard(BoardOptions.TWO_HUMANS);
  }

  /** Runs the game */
  public void run() {
    while (!this.board.isGameOver()) {
      this.drawBoard();

      System.out.println("Current Player: " + this.board.getCurrentPlayer());

      this.board.playerMakeMove();
      this.board.shiftPlayers();
    }

    this.drawBoard();

    if (this.board.getWinningPlayer() == null) {
      System.out.println("It was a tie!!!");
    } else {
      System.out.println(this.board.getWinningPlayer() + " wins!!!");
    }
  }

  /** Draws the board to the terminal */
  public void drawBoard() {
    System.out.print("   ");
    for (int i = 0; i < this.board.size(); i++) {
      System.out.print(i + "  ");
    }
    System.out.println(); // new line

    for (int i = 0; i < this.board.size(); i++) {
      System.out.print(i + " ");
      for (int j = 0; j < this.board.size(); j++) {
        System.out.print("[" + this.board.getCharAt(i, j) + "]");
      }
      System.out.println(); // new line
    }
  }
}
