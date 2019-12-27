package model.players;

import model.moves.Move;

/**
 * Player.java
 *
 * An abstract player that all other players will implement from
 *
 * @author Chris Wolf
 * @version 1.0.0 (December 27, 2019)
 */
public abstract class Player {
    /** the player's name */
    private String name;
    /** the character that will represent the player on the board (X/O) */
    private char representation;

    /**
     * Constructor
     * @param name the player's name
     * @param representation the character that will represent the player on
     *                       the board (X/O)
     */
    public Player(String name, char representation) {
        this.name = name;
        this.representation = representation;
    }

    /**
     * Getter for representation
     * @return representation
     */
    public char getRepresentation() {
        return representation;
    }

    /**
     * Allows a player to attempt to make a move
     * @return the move the player is attempting
     */
    public abstract Move proposeMove();

    /**
     * Equals method
     * @param other the other object we are comparing to
     * @return true if this and other are the same, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Player player = (Player) other;
        return representation == player.representation &&
                name.equals(player.name);
    }

    /**
     * ToString method
     * @return string representation of this object
     */
    @Override
    public String toString() {
        return this.name;
    }
}
