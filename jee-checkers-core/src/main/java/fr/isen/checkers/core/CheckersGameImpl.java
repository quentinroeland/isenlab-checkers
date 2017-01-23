package fr.isen.checkers.core;

import fr.isen.checkers.core.board.Board;
import fr.isen.checkers.core.exceptions.BoardException;
import fr.isen.checkers.core.cell.Cell;
import fr.isen.checkers.core.exceptions.MoveException;
import fr.isen.checkers.core.pawns.Pawn;
import fr.isen.checkers.core.pawns.PawnColor;

/**
 * Created by Quentin on 09/01/2017.
 */
public class CheckersGameImpl implements CheckersGame {

    public static final Integer COLUMNS_NUMBER = 10;
    public static final Integer ROWS_NUMBER = 10;
    public static final Integer ROWS_OF_PAWNS = 4;

    public static final String OUTSIDE_OF_BOARD_ERROR = "It is not possible to play outside of the board";

    private Board board;
    private Player player1;
    private Player player2;

    public CheckersGameImpl(){
        this.player1 = new Player("Player 1", PawnColor.WHITE);
        this.player2 = new Player("Player 2", PawnColor.BLACK);
        this.board = new Board(ROWS_NUMBER, COLUMNS_NUMBER);
    }

    @Override
    public void init() {
        this.board.setupPawns(player1, player2, ROWS_OF_PAWNS);
    }

    @Override
    public void play(Player player, Pawn pawn) {
    }

    @Override
    public void displayGameBoard() {
        this.board.display();
        //this.board.displayCellColor();
    }

    @Override
    public Cell getBoardCell(int row, int col) throws BoardException {
        return this.board.getCell(row,col);
    }

    @Override
    public Cell getBoardCell(Position p) {
        return this.getBoardCell(p.getRowIndex(),p.getColIndex());
    }

    @Override
    public Board getBoard(){
        return this.board;
    }
    @Override
    public Player getPlayer1() {
        return player1;
    }

    @Override
    public Player getPlayer2() {
        return player2;
    }

    @Override
    public void move(Position origin, Position destination) throws MoveException {
        this.getBoard().Move(this.getBoardCell(origin).getPawn(), destination);
    }

    @Override
    public void setPlayers(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
}
