package fr.isen.checkers.core;

import fr.isen.checkers.core.cell.Cell;

/**
 * Created by Quentin on 09/01/2017.
 */
public interface CheckersGame {
    public void initGameBoard();

    public void play(PawnColor pc, int col, int row);

    public void displayGameBoard();

    public void init();

    Cell getBoardCell(int row , int col);
}
