package model.boards;

import model.moves.Move;
import model.players.Player;
import org.jetbrains.annotations.NotNull;

public abstract class Board {
    private Player playerOne;
    private Player playerTwo;
    private Player CurrentPlayer;
    private char[][] grid;
    private static final int GRID_SIZE = 3;

    public Board() {
        this.grid = new char[GRID_SIZE][GRID_SIZE];
        this.initializeGrid();
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public Player getCurrentPlayer() {
        return CurrentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        CurrentPlayer = currentPlayer;
    }

    public int size() {
        return GRID_SIZE;
    }

    public void initializeGrid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                this.grid[i][j] = ' ';
            }
        }
    }

    public char getCharAt(int row, int col) {
        return this.grid[row][col];
    }

    public void makeMove(@NotNull Move move, @NotNull Player player) {
        this.grid[move.getRow()][move.getCol()] = player.getRepresentation();
    }

    public boolean isGameOver() {
        return this.remainingSquares() == 0 || this.getWinningPlayer() != null;
    }

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

    public Player getWinningPlayer() {
        if (this.hasPlayerWon(this.getPlayerOne())) {
            return this.getPlayerOne();
        }

        if (this.hasPlayerWon(this.getPlayerTwo())) {
            return this.getPlayerTwo();
        }

        return null;
    }

    public boolean hasPlayerWon(Player player) {
        return false;
    }

}
