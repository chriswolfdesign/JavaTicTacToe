package model.boards;

import model.moves.Move;
import model.players.Player;
import org.jetbrains.annotations.NotNull;

public abstract class Board {
    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer;
    private char[][] grid;
    private static final int GRID_SIZE = 3;

    public Board() {
        this.grid = new char[GRID_SIZE][GRID_SIZE];
        this.initializeGrid();
        this.setCurrentPlayer(this.playerOne);
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
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
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

    public void playerMakeMove() {
        Move move;

        do {
            move = this.getCurrentPlayer().proposeMove();
        } while (!this.isValidMove(move));

        this.makeMove(move, this.getCurrentPlayer());
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
        return this.hasPlayerWonByRows(player) || this.hasPlayerWonByCols(player) ||
                this.hasPlayerWonByDiags(player);
    }

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

    private boolean hasPlayerWonByDiags(Player player) {
        return this.hasPlayerWonByTopLeftBottomRightDiag(player) ||
                this.hasPlayerWonByTopRightBottomLeftDiag(player);
    }

    private boolean hasPlayerWonByTopRightBottomLeftDiag(Player player) {
        for (int i = 0; i < this.size(); i++) {
            if (this.getCharAt(i, (this.size() - i - 1)) != player.getRepresentation()) {
                return false;
            }
        }

        return true;
    }

    private boolean hasPlayerWonByTopLeftBottomRightDiag(Player player) {
        for (int i = 0; i < this.size(); i++) {
            if (this.getCharAt(i, i) != player.getRepresentation()) {
                return false;
            }
        }

        return true;
    }

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
