package fr.isen.checkers.core.cell;

import fr.isen.checkers.core.Position;
import fr.isen.checkers.core.pawns.Pawn;

/**
 * Created by Quentin on 09/01/2017.
 */
public class Cell {

    private Position position;
    private CellColor color;
    private Pawn pawn;

    public Cell(Integer row, Integer col){
        this(new Position(row,col));
    }

    public Cell(Position p){
        this.position = p;
        this.setCellColor();
    }

    private void setCellColor() {
        Integer rowModule = this.position.getRowIndex() % 2;
        Integer colModule = this.position.getColIndex() % 2;
        if(rowModule == 0){
            if(colModule == 0){
                this.color =  CellColor.Light;
            }else{
                this.color =  CellColor.Dark;
            }
        }else{
            if(colModule == 0){
                this.color =  CellColor.Dark;
            }else{
                this.color =  CellColor.Light;
            }
        }
    }

    public CellColor getColor(){
        return this.color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPawn(Pawn pawn) {
        this.pawn = pawn;
    }

    public Pawn getPawn() {
        return pawn;
    }

    public boolean hasPawnAtInit() {
        Boolean response = false;

        Integer rowModule = this.getPosition().getRowIndex() % 2;
        Integer colModule = this.getPosition().getColIndex() % 2;

        if (rowModule == 0) {
            if (colModule != 0) {
                response = true;
            }
        } else {
            if (colModule == 0) {
               response = true;
            }
        }

        return response;
    }
}
