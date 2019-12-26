package factories;

import model.games.CLIGame;
import model.games.Game;
import model.games.GameOptions;

public abstract class GameFactory {
    public static Game generateGame(GameOptions choice) {
        switch(choice) {
            case CLI:
                return new CLIGame();
            default:
                return null;
        }
    }
}
