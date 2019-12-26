package factories;

import model.players.HumanPlayer;
import model.players.Player;
import model.players.PlayerOptions;

public class PlayerFactory {
    public static Player generatePlayer(PlayerOptions choice,
                                        String name, char representation) {
        switch(choice) {
            case HUMAN_PLAYER:
                return new HumanPlayer(name, representation);
            default:
                return null;
        }
    }
}
