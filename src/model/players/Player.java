package model.players;

import model.moves.Move;

public abstract class Player {
    private String name;
    private char representation;

    public Player(String name, char representation) {
        this.name = name;
        this.representation = representation;
    }

    public String getName() {
        return name;
    }

    public char getRepresentation() {
        return representation;
    }

    public abstract Move proposeMove();
}
