package model.players;

import model.moves.Move;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return representation == player.representation &&
                name.equals(player.name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
