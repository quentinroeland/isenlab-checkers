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
        this(10, 10);
    }

    public Board(Integer numberOfRows, Integer numberOfCols){
        this.rows = numberOfRows;
        this.cols = numberOfCols;
        this.initGameBoard();
    }

    public void initGameBoard() {
        this.createBoard();
        this.setupPawn();
    }

    public void createBoard(){
        this.board = new ArrayList<List<Cell>>(this.rows);
        for (Integer i = 0; i < this.rows; i++) {
            this.board.add(new ArrayList<Cell>(this.cols));
        }
    }

    public void setupPawn(){
        for(Integer row = 0 ; row < this.rows; row ++){
            List<Cell> currentRow = new ArrayList<>(this.cols);
            for(Integer col = 0 ; col < this.cols; col ++){
                CellColor cellColor = this.getInitialCellColor(row, col);
                CellContent cellContent = this.getInitialCellContent(row, col);
                Cell currentCell = new Cell(cellColor, cellContent);
                currentRow.add(currentCell);
            }
            this.board.set(row, currentRow);
        }
    }

    private CellContent getInitialCellContent(Integer row, Integer col) {
        CellContentType cellContentType;
        PawnColor pawnColor;
        Integer rowModule = row % 2;
        Integer colModule = col % 2;
        if(row < 4 || row > this.rows - 1 - 4 ) {
            if (rowModule == 0) {
                if (colModule == 0) {
                    cellContentType = CellContentType.EMPTY;
                } else {
                    cellContentType = CellContentType.PAWN;
                }
            } else {
                if (colModule == 0) {
                    cellContentType = CellContentType.PAWN;
                } else {
                    cellContentType = CellContentType.EMPTY;
                }
            }
        }else{
            cellContentType = CellContentType.EMPTY;
        }
        if(row <4 && cellContentType != CellContentType.EMPTY){
            pawnColor = PawnColor.BLACK;
        }else{
            if(row >this.rows - 1 - 4 && cellContentType != CellContentType.EMPTY ){
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
                return CellColor.Light;
            }else{
                return CellColor.Dark;
            }
        }else{
            if(colModule == 0){
                return CellColor.Dark;
            }else{
                return CellColor.Light;
            }
        }
    }

    public Cell getCell(int row, int col) throws BoardException {
        try{
            return this.board.get(row).get(col);
        }catch (IndexOutOfBoundsException e){
            BoardException boardExeception = new BoardException("Not a valid index for board cell");
            throw boardExeception ;
        }
    }

    public void display() {
        for(List<Cell> rows : this.board){
            System.out.print("|");
            for(Cell c : rows){
                CellContent content = c.getContent();
                if(content.getType() == CellContentType.EMPTY){
                    System.out.print("__");
                }
                else if(content.getType() == CellContentType.PAWN){
                    if(content.getColor() == PawnColor.BLACK){
                        System.out.print("B.");
                    }
                    else if(content.getColor() == PawnColor.WHITE){
                        System.out.print("W.");
                    }
                }
                else if(content.getType() == CellContentType.KING){
                    if(content.getColor() == PawnColor.BLACK){
                        System.out.print("B:");
                    }
                    else if(content.getColor() == PawnColor.WHITE){
                        System.out.print("W:");
                    }
                }
                System.out.print("|");
            }
            System.out.println("");
        }
    }
}
