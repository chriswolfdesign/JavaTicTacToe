package model.players;

import model.moves.Move;

import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, char representation) {
        super(name, representation);
    }

    @Override
    public Move proposeMove() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter row: ");
        int row = scan.nextInt();
        System.out.print("Enter col: ");
        int col = scan.nextInt();

        return new Move(row, col);
    }
}
