package model.boards;

import factories.PlayerFactory;
import model.players.HumanPlayer;
import model.players.Player;
import model.players.PlayerOptions;

public class TwoHumanBoard extends Board {
    public TwoHumanBoard() {
        super();
        Player playerOne = PlayerFactory.generatePlayer(PlayerOptions.HUMAN_PLAYER,
                        "Player One", 'X');
        Player playerTwo = PlayerFactory.generatePlayer(PlayerOptions.HUMAN_PLAYER,
                "Player Two", 'O');
        this.setPlayerOne(playerOne);
        this.setPlayerTwo(playerTwo);
        this.setCurrentPlayer(this.getPlayerOne());
    }
}
