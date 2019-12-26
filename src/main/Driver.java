package main;

import factories.GameFactory;
import model.games.Game;
import model.games.GameOptions;

public class Driver {
    public static void main(String[] args) {
        Game game = GameFactory.generateGame(GameOptions.CLI);
        game.run();
    }
}
