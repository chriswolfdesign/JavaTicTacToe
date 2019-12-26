package model.players;

import model.moves.Move;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, char representation) {
        super(name, representation);
    }

    @Override
    public Move proposeMove() {
        return null;
    }
}
