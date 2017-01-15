package fr.isen.checkers.core;

import fr.isen.checkers.core.cell.Cell;
import fr.isen.checkers.core.pawns.Pawn;

/**
 * Created by Quentin on 09/01/2017.
 */
public interface CheckersGame {
    public void init();

    public void play(Player player, Pawn pawn);

    public void displayGameBoard();

    Cell getBoardCell(int row , int col);

    Cell getBoardCell(Position p);

    Player getPlayer1();

    Player getPlayer2();
}
