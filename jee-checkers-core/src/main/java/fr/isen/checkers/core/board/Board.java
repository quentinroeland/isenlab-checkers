package fr.isen.checkers.core.board;

import fr.isen.checkers.core.PawnColor;
import fr.isen.checkers.core.cell.Cell;
import fr.isen.checkers.core.cell.CellColor;
import fr.isen.checkers.core.cell.CellContent;
import fr.isen.checkers.core.cell.CellContentType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 09/01/2017.
 */
public class Board {

    private Integer rows;
    private Integer cols;

    private List<List<Cell>> board;

    public Board(){
        new Board(10, 10);
    }

    public Board(Integer numberOfRows, Integer numberOfCols){
        this.rows = numberOfRows;
        this.cols = numberOfCols;
        initGameBoard();
    }

    public void initGameBoard() {
        createBoard();
        setupPawn();
    }

    public void createBoard(){
        this.board = new ArrayList<List<Cell>>(this.rows);
        for (Integer i = 0; i < this.rows; i++) {
            board.add(new ArrayList<Cell>(this.cols));
        }
    }

    public void setupPawn(){
        for(Integer row = 0 ; row < this.rows; row ++){
            List<Cell> currentRow = new ArrayList<>(this.cols);
            for(Integer col = 0 ; col < this.cols; col ++){
                CellColor cellColor = this.getInitialCellColor(row, col);
                CellContent cellContent = this.getInitialCellContent(row, col);
                Cell currentCell = new Cell(cellColor, cellContent);
                currentRow.set(col, currentCell);
            }
            board.set(row, currentRow);
        }
    }

    private CellContent getInitialCellContent(Integer row, Integer col) {
        CellContentType cellContentType;
        PawnColor pawnColor;
        Integer rowModule = row % 2;
        Integer colModule = col % 2;
        if(row < 4 && row > this.rows - 1 - 4 ) {
            if (rowModule == 0) {
                if (colModule == 0) {
                    cellContentType = CellContentType.PAWN;
                } else {
                    cellContentType = CellContentType.EMPTY;
                }
            } else {
                if (colModule == 0) {
                    cellContentType = CellContentType.EMPTY;
                } else {
                    cellContentType = CellContentType.PAWN;
                }
            }
        }else{
            cellContentType = CellContentType.EMPTY;
        }
        if(row <4 && cellContentType != CellContentType.EMPTY){
            pawnColor = PawnColor.BLACK;
        }else{
            if(row >this.rows - 1 - 4 ){
                pawnColor = PawnColor.WHITE;
            }else{
                pawnColor = PawnColor.NULL;
            }
        }
        return new CellContent(cellContentType, pawnColor);
    }

    private CellColor getInitialCellColor(Integer row, Integer col) {
        Integer rowModule = row % 2;
        Integer colModule = col % 2;
        if(rowModule == 0){
            if(colModule == 0){
                return CellColor.Dark;
            }else{
                return CellColor.Light;
            }
        }else{
            if(colModule == 0){
                return CellColor.Light;
            }else{
                return CellColor.Dark;
            }
        }
    }

    public void setupWhitePawn(){

    }

    public void setupBlackPawn(){
    }

    public Cell getCell(int row, int col) throws BoardException {
        try{
            return this.board.get(row).get(col);
        }catch (IndexOutOfBoundsException e){
            BoardException boardExeception = new BoardException("Not a valid index for board cell");
            throw boardExeception ;
        }
    }
}
