package factories;

import model.boards.Board;
import model.boards.BoardOptions;
import model.boards.TwoHumanBoard;

/**
 * BoardFactory.java
 *
 * Generates the type of board the player would like to play on
 *
 * @author Chris Wolf
 * @version 1.0.0 (December 27, 2019)
 */
public class BoardFactory {
    /**
     * generates the board to be played on
     * @param board the type of board the user would like to play on
     * @return the correct board based on input
     */
    public static Board generateBoard(BoardOptions board) {
        switch(board) {
            case TWO_HUMANS:
                return new TwoHumanBoard();
            default:
                return null;
        }
    }


}
