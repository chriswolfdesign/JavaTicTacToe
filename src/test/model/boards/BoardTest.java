package test.model.boards;

import model.boards.Board;
import model.boards.TwoHumanBoard;
import model.moves.Move;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    Board board;

    @Before
    public void setup() {
        board = new TwoHumanBoard();
    }

    /**
     * makeMove tests
     */
    @Test
    public void testMakeMoveEmptyBoard() {
        assertEquals(board.getCharAt(1, 1), ' ');
        board.makeMove(new Move(1, 1), board.getPlayerOne());
        assertEquals(board.getCharAt(1, 1),
                board.getPlayerOne().getRepresentation());
    }

    @Test
    public void testMakeMovePartiallyFilledBoard() {
        board.makeMove(new Move(0, 0), board.getPlayerOne());
        board.makeMove(new Move(0, 2), board.getPlayerTwo());
        board.makeMove(new Move(2, 0), board.getPlayerOne());
        board.makeMove(new Move(2, 2), board.getPlayerTwo());

        assertEquals(board.getCharAt(1, 1), ' ');
        board.makeMove(new Move(1, 1), board.getPlayerTwo());
        assertEquals(board.getCharAt(1, 1),
                board.getPlayerTwo().getRepresentation());
    }

    @Test
    public void testMakeMoveFilledBoard() {
        board.makeMove(new Move(0, 0), board.getPlayerOne());
        board.makeMove(new Move(1, 0), board.getPlayerOne());
        board.makeMove(new Move(2, 0), board.getPlayerOne());
        board.makeMove(new Move(0, 1), board.getPlayerOne());
        board.makeMove(new Move(2, 1), board.getPlayerOne());
        board.makeMove(new Move(0, 2), board.getPlayerOne());
        board.makeMove(new Move(1, 2), board.getPlayerOne());
        board.makeMove(new Move(2, 2), board.getPlayerOne());

        assertEquals(board.getCharAt(1, 1), ' ');
        board.makeMove(new Move(1, 1), board.getPlayerTwo());
        assertEquals(board.getCharAt(1, 1), board.getPlayerTwo().getRepresentation());
    }

    /**
     * isGameOver tests
     */
    @Test
    public void isGameOverFalse() {
        board.makeMove(new Move(0, 0), board.getPlayerOne());
        board.makeMove(new Move(0, 2), board.getPlayerTwo());
        board.makeMove(new Move(2, 0), board.getPlayerTwo());
        board.makeMove(new Move(2, 2), board.getPlayerOne());

        assertFalse(board.isGameOver());
    }

    @Test
    public void isGameOverTrueNoSquaresRemaining() {
        setupFullBoard();

        assertTrue(board.isGameOver());
    }

    @Test
    public void isGameOverTruePlayerOneWon() {
        board.makeMove(new Move(0, 0), board.getPlayerOne());
        board.makeMove(new Move(0, 1), board.getPlayerOne());
        board.makeMove(new Move(0 , 2), board.getPlayerOne());

        assertTrue(board.isGameOver());
    }

    @Test
    public void isGameOverTruePlayerTwoWon() {
        board.makeMove(new Move(0, 0), board.getPlayerTwo());
        board.makeMove(new Move(1, 0), board.getPlayerTwo());
        board.makeMove(new Move(2, 0), board.getPlayerTwo());

        assertTrue(board.isGameOver());
    }

    /**
     * remainingSquares tests
     */
    @Test
    public void remainingSquaresEmptyBoard() {
        assertEquals(board.remainingSquares(), 9);
    }

    @Test
    public void remainingSquaresPartiallyFilledBoard() {
        board.makeMove(new Move(0, 0), board.getPlayerOne());
        board.makeMove(new Move(0, 2), board.getPlayerTwo());
        board.makeMove(new Move(2, 0), board.getPlayerOne());
        board.makeMove(new Move(2, 2), board.getPlayerTwo());

        assertEquals(board.remainingSquares(), 5);
    }

    @Test
    public void remainingSquaresFilledBoard() {
        setupFullBoard();

        assertEquals(board.remainingSquares(), 0);
    }

    private void setupFullBoard() {
        board.makeMove(new Move(0, 0), board.getPlayerOne());
        board.makeMove(new Move(0 ,1), board.getPlayerTwo());
        board.makeMove(new Move(0, 2), board.getPlayerOne());
        board.makeMove(new Move(1, 0), board.getPlayerOne());
        board.makeMove(new Move(1, 1), board.getPlayerTwo());
        board.makeMove(new Move(1, 2), board.getPlayerOne());
        board.makeMove(new Move(2, 0), board.getPlayerTwo());
        board.makeMove(new Move(2, 1), board.getPlayerOne());
        board.makeMove(new Move(2, 2), board.getPlayerTwo());
    }
}

