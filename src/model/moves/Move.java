package model.moves;

/**
 * Move.java
 *
 * Represents a possible move that may be made in our Tic-Tac-Toe game
 *
 * @author Chris Wolf
 * @version 1.0.0 (December 27, 2019)
 */
public class Move {
    /** the row this move will be made on */
    private int row;
    /** the column this move will be made on */
    private int col;

    /**
     * Constructor
     * @param row the row this move will represent
     * @param col the column this move will represent
     */
    public Move(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Getter for row
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * Getter for column
     * @return col
     */
    public int getCol() {
        return col;
    }

}
