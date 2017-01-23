package fr.isen.checkers.core;

import fr.isen.checkers.core.board.Board;
import fr.isen.checkers.core.cell.Cell;
import fr.isen.checkers.core.exceptions.MoveException;
import fr.isen.checkers.core.pawns.Pawn;

import java.io.Serializable;

/**
 * Created by Quentin on 09/01/2017.
 */
public interface CheckersGame extends Serializable {
    public void init();

    public void play(Player player, Pawn pawn);

    public void displayGameBoard();

    Cell getBoardCell(int row , int col);

    Cell getBoardCell(Position p);

    Board getBoard();

    Player getPlayer1();

    Player getPlayer2();

    public void move(Position origin, Position destination) throws MoveException;

    public void setPlayers(Player player1, Player player2);
}
