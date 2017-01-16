package fr.isen.checkers.core.board;

import fr.isen.checkers.core.Player;
import fr.isen.checkers.core.Position;
import fr.isen.checkers.core.cell.Cell;
import fr.isen.checkers.core.cell.CellColor;
import fr.isen.checkers.core.exceptions.BoardException;
import fr.isen.checkers.core.exceptions.MoveException;
import fr.isen.checkers.core.pawns.Pawn;
import fr.isen.checkers.core.pawns.SimplePawn;

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
        this.createBoard();
    }

    public void createBoard(){
        this.board = new ArrayList<List<Cell>>(this.rows);
        for (Integer r = 0; r < this.rows; r++) {
            List<Cell> currentRow = new ArrayList<Cell>(this.cols);
            for(Integer c = 0; c <this.cols; c++){
                currentRow.add(new Cell(r,c));
            }
            this.board.add(currentRow);
        }
    }

    public void setupPawns(Player p1, Player p2, Integer nbRows){
        setupPawnsPlayer(p1, 0, nbRows);
        setupPawnsPlayer(p2, this.rows-nbRows, this.rows);
    }

    public void setupPawnsPlayer(Player p1, Integer rowBegin, Integer rowEnd) {
        for (Integer rowIndex = rowBegin; rowIndex < rowEnd; rowIndex++) {
            List<Cell> row = this.board.get(rowIndex);
            for (Cell cell : row) {
                if (cell.hasPawnAtInit()) {
                    SimplePawn pawn = new SimplePawn(p1, cell.getPosition());
                    p1.addPawn(pawn);
                    cell.setPawn(pawn);
                }
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

    public Cell getCell(Position p){
        return getCell(p.getRowIndex(), p.getColIndex());
    }

    public void Move(Pawn pawn, Position nextPosition) throws MoveException {
        Cell currentCell = this.getCell(pawn.getPosition());


        Cell nextCell = this.getCell(nextPosition);
        if(nextCell.getPawn() != null){
            throw new MoveException("Move not allowed : the cell is not empty");
        }
        else{
            currentCell.setPawn(null);
            pawn.setPosition(nextPosition);
            nextCell.setPawn(pawn);
        }
    }

    public void displayCellColor() {
        for (List<Cell> rows : this.board) {
            System.out.print("|");
            for (Cell c : rows) {
                if (c.getColor() == CellColor.Dark) {
                    System.out.print("D");
                } else if (c.getColor() == CellColor.Light) {
                    System.out.print("L");
                }
                System.out.print("|");
            }
            System.out.println("");
        }
    }

    public void display(){
        for (List<Cell> rows : this.board) {
            System.out.print("|");
            for (Cell c : rows) {
                if (c.getPawn() != null) {
                    System.out.print(c.getPawn().getColor().name().substring(0,1));
                } else {
                    System.out.print("_");
                }
                System.out.print("|");
            }
            System.out.println("");
        }
    }
}
