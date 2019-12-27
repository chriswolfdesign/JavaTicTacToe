package model.boards;

import model.moves.Move;
import model.players.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Board.java
 *
 * A generic board that all other boards can inherit from
 *
 * @author Chris Wolf
 * @version 1.0.0 (December 27, 2019)
 */
public abstract class Board {
    /** player one in the game */
    private Player playerOne;
    /** player two in the game */
    private Player playerTwo;
    /** the player who's turn it is */
    private Player currentPlayer;
    /** the grid that will hold all moves that have been made */
    private char[][] grid;
    /** the size of the board */
    private static final int GRID_SIZE = 3;

    /**
     * Constructor
     */
    public Board() {
        this.grid = new char[GRID_SIZE][GRID_SIZE];
        this.initializeGrid();
        this.setCurrentPlayer(this.playerOne);
    }

    /**
     * Getter for player one
     * @return playerOne
     */
    public Player getPlayerOne() {
        return playerOne;
    }

    /**
     * Setter for player one
     * @param playerOne new value for playerOne
     */
    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    /**
     * Getter for player two
     * @return playerTwo
     */
    public Player getPlayerTwo() {
        return playerTwo;
    }

    /**
     * Setter for player two
     * @param playerTwo new value for player two
     */
    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    /**
     * Getter for current player
     * @return currentPlayer
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Setter for current player
     * @param currentPlayer new value for currentPlayer
     */
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    /**
     * Retrieves the one-dimensional size of the board
     * @return GRID_SIZE
     */
    public int size() {
        return GRID_SIZE;
    }

    /**
     * Sets up the grid full of empty squares
     */
    public void initializeGrid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                this.grid[i][j] = ' ';
            }
        }
    }

    /**
     * Retrieves the char at a specific index in the grid
     * @param row the row we are searching for
     * @param col the column we are searching for
     * @return the character at index [row][column]
     */
    public char getCharAt(int row, int col) {
        return this.grid[row][col];
    }

    /**
     * Places the player's character at a specific space
     * @param move the space the user would like to make the move on
     * @param player the player making the move
     */
    public void makeMove(@NotNull Move move, @NotNull Player player) {
        this.grid[move.getRow()][move.getCol()] = player.getRepresentation();
    }

    /**
     * Allows a player to make a move
     */
    public void playerMakeMove() {
        Move move;

        do {
            move = this.getCurrentPlayer().proposeMove();
        } while (!this.isValidMove(move));

        this.makeMove(move, this.getCurrentPlayer());
    }

    /**
     * Determines whether or not the game is over
     * @return true if game is over, false otherwise
     */
    public boolean isGameOver() {
        return this.remainingSquares() == 0 || this.getWinningPlayer() != null;
    }

    /**
     * Calculates the number of empty squares left on the board
     * @return empty squares left on the board
     */
    public int remainingSquares() {
        int remainingSquares = 0;

        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < this.size(); j++) {
                if (this.getCharAt(i, j) == ' ') {
                    remainingSquares++;
                }
            }
        }

        return remainingSquares;
    }

    /**
     * Determines who has won the game
     * @return playerOne/playerTwo if one of them has won, false otherwise
     */
    public Player getWinningPlayer() {
        if (this.hasPlayerWon(this.getPlayerOne())) {
            return this.getPlayerOne();
        }

        if (this.hasPlayerWon(this.getPlayerTwo())) {
            return this.getPlayerTwo();
        }

        return null;
    }

    /**
     * Determines whether or not a player has won the game
     * @param player the player we are checking for
     * @return true if the player has won the game, false otherwise
     */
    public boolean hasPlayerWon(Player player) {
        return this.hasPlayerWonByRows(player) || this.hasPlayerWonByCols(player) ||
                this.hasPlayerWonByDiags(player);
    }

    /**
     * Determines whether or not the player has won by getting three in a row
     * @param player the player we are checking
     * @return true if the player has won by rows, false otherwise
     */
    private boolean hasPlayerWonByRows(Player player) {
        boolean hasPlayerWon;

        for (int i = 0; i < this.size(); i++) {
            hasPlayerWon = true;
            for (int j = 0; j < this.size(); j++) {
                if (this.getCharAt(i, j) != player.getRepresentation()) {
                    hasPlayerWon = false;
                }
            }

            if (hasPlayerWon) {
                return true;
            }
        }

        return false;
    }

    /**
     * Determines whether or not the player has won by three in a column
     * @param player the player we are checking
     * @return true if the player has won by columns, false otherwise
     */
    private boolean hasPlayerWonByCols(Player player) {
        boolean hasPlayerWon;

        for (int i = 0; i < this.size(); i++) {
            hasPlayerWon = true;
            for (int j = 0; j < this.size(); j++) {
                if (this.getCharAt(j, i) != player.getRepresentation()) {
                    hasPlayerWon = false;
                }
            }

            if (hasPlayerWon) {
                return true;
            }
        }

        return false;
    }

    /**
     * Determines whether or not a player has won by three in a diagonal
     * @param player the player we are checking
     * @return true if the player has won by diagonals, false otherwise
     */
    private boolean hasPlayerWonByDiags(Player player) {
        return this.hasPlayerWonByTopLeftBottomRightDiag(player) ||
                this.hasPlayerWonByTopRightBottomLeftDiag(player);
    }

    /**
     * Determines whether or not the player has won by three in the top-left
     * to bottom-right diagonal
     * @param player the player we are checking
     * @return true if the player has won by three in the top-left to
     * bottom-right diagonal, false otherwise
     */
    private boolean hasPlayerWonByTopRightBottomLeftDiag(Player player) {
        for (int i = 0; i < this.size(); i++) {
            if (this.getCharAt(i, (this.size() - i - 1)) != player.getRepresentation()) {
                return false;
            }
        }

        return true;
    }

    /**
     * Determines whether or not the player has won by three in the top-right
     * to bottom-left diagonal
     * @param player the player we are checking
     * @return true if the player has won by three in the top-right to
     * bottom-left diagonal, false otherwise
     */
    private boolean hasPlayerWonByTopLeftBottomRightDiag(Player player) {
        for (int i = 0; i < this.size(); i++) {
            if (this.getCharAt(i, i) != player.getRepresentation()) {
                return false;
            }
        }

        return true;
    }

    /**
     * Determines whether or not a move is valid on this board or not
     * @param move the move we are checking
     * @return true if the move is valid, false otherwise
     */
    public boolean isValidMove(Move move) {
        if (move.getRow() < 0 || move.getRow() >= this.size()) {
            return false;
        }

        if (move.getCol() < 0 || move.getCol() >= this.size()) {
            return false;
        }

        return this.getCharAt(move.getRow(), move.getCol()) == ' ';
    }

    public void shiftPlayers() {
        if (this.getCurrentPlayer().equals(this.getPlayerOne())) {
            this.currentPlayer = this.playerTwo;
        } else {
            this.currentPlayer = this.playerOne;
        }
    }

}
