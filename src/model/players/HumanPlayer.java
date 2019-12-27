package model.players;

import model.moves.Move;

import java.util.Scanner;

/**
 * HumanPlayer.java
 *
 * <p>A human player in our Tic-Tac-Toe game
 *
 * @author Chris Wolf
 * @version 1.0.0 (December 27, 2019)
 */
public class HumanPlayer extends Player {
  /**
   * Constructor
   *
   * @param name the name of the player
   * @param representation the character that will represent our player on the board (X/O)
   */
  public HumanPlayer(String name, char representation) {
    super(name, representation);
  }

  /**
   * Allows the player to attempt to make a move
   *
   * @return the move the player has made
   */
  @Override
  public Move proposeMove() {
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter row: ");
    int row = scan.nextInt();
    System.out.print("Enter col: ");
    int col = scan.nextInt();

    return new Move(row, col);
  }
}
