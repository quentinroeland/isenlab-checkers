package fr.isen.checkers.core.board;

import fr.isen.checkers.core.cell.Cell;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 09/01/2017.
 */
public class Board {

    private int rows;
    private int cols;

    private List<List<Cell>> board;

    public Board(){
        new Board(10, 10);
    }

    public Board(int number_of_rows, int number_of_cols){
        this.rows = number_of_rows;
        this.cols = number_of_cols;
        initGameBoard();
    }

    public void initGameBoard() {
        createBoard();
        setupPawn();
    }

    public void createBoard(){
        this.board = new ArrayList<List<Cell>>(this.rows);
        for (int i = 0; i < this.rows; i++) {
            board.add(new ArrayList<Cell>(this.cols));
        }
    }

    public void setupPawn(){
        setupWhitePawn();
        setupBlackPawn();
    }

    public void setupWhitePawn(){

    }

    public void setupBlackPawn(){
    }
}
