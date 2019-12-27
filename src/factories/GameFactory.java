package factories;

import model.games.CLIGame;
import model.games.Game;
import model.games.GameOptions;

/**
 * GameFactory.java
 *
 * Generates the appropriate game the user would like to play
 *
 * @author Chris Wolf
 * @version 1.0.0 (December 27, 2019)
 */
public abstract class GameFactory {
    /**
     * Generates the appropriate game
     * @param choice the type of game the user would like to play on
     * @return the game based on user choice
     */
    public static Game generateGame(GameOptions choice) {
        switch(choice) {
            case CLI:
                return new CLIGame();
            default:
                return null;
        }
    }
}
