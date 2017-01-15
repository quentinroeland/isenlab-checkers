package fr.isen.checkers.core;

import fr.isen.checkers.core.board.Board;
import fr.isen.checkers.core.board.BoardException;
import fr.isen.checkers.core.cell.Cell;

/**
 * Created by Quentin on 09/01/2017.
 */
public class CheckersGameImpl implements CheckersGame {

    public static final Integer COLUMNS_NUMBER = 10;
    public static final Integer ROWS_NUMBER = 10;
    public static final Integer NUMBER_OF_WHITE_PAWNS = 20;
    public static final Integer NUMBER_OF_BLACK_PAWNS = 20;

    public static final String OUTSIDE_OF_BOARD_ERROR = "It is not possible to play outside of the board";

    private Board board;

    public CheckersGameImpl(){
        Board b = new Board();
        this.board = b;
    }

    public void initGameBoard() {
        //this.board.initGameBoard();
    }

    public void play(PawnColor pc, int col, int row) {

    }


    public void displayGameBoard() {
        this.board.display();
    }

    @Override
    public void init() {

    }

    @Override
    public Cell getBoardCell(int row, int col) throws BoardException {
        return this.board.getCell(row,col);
    }

    public PawnColor getCurrentColor(){
        return PawnColor.WHITE;
    }
}
