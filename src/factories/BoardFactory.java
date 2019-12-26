package factories;

import model.boards.Board;
import model.boards.BoardOptions;
import model.boards.TwoHumanBoard;

public class BoardFactory {
    public static Board generateBoard(BoardOptions board) {
        switch(board) {
            case TWO_HUMANS:
                return new TwoHumanBoard();
            default:
                return null;
        }
    }


}
