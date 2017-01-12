package fr.isen.checkers.core;

import fr.isen.checkers.core.board.Board;
import fr.isen.checkers.core.cell.Cell;

import java.util.List;

/**
 * Created by Quentin on 09/01/2017.
 */
public class CheckersGameImpl implements CheckersGame {

    public static final int COLUMNS_NUMBER = 10;
    public static final int ROWS_NUMBER = 10;
    public static final int NUMBER_OF_WHITE_PAWNS = 20;
    public static final int NUMBER_OF_BLACK_PAWNS = 20;

    public static final String OUTSIDE_OF_BOARD_ERROR = "It is not possible to play outside of the board";

    private Board board;

    public CheckersGameImpl(){
        this.board = new Board();
    }


    public void initGameBoard() {

    }

    public void play(PawnColor pc, int col, int row) {

    }

    public void setupWhitePawn(){

    }

    public void setupBlackPawn(){

    }
    public void displayGameBoard() {
    }

    @Override
    public void init() {

    }

    @Override
    public Cell getBoardCell(int row, int col) {
        return null;
    }

    public PawnColor getCurrentColor(){
        return PawnColor.WHITE;
    }
}
