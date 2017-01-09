package src.main.java.fr.isen.checkers.core.cell;

import src.main.java.fr.isen.checkers.core.PawnColor;

/**
 * Created by Quentin on 09/01/2017.
 */
public class Cell {

    private Boolean isFree;
    private CellColor color;

    public Cell(CellColor cc){
        this.color = cc;
    }

    public Cell(CellColor cc, PawnColor pc){
        this.color = cc;
        this.isFree = false;
    }

    public void setColor(CellColor cc){
        this.color = cc;
    }

    public CellColor getColor(){
        return this.color;
    }

    public void setIsFree(boolean newFreeState){
        this.isFree = newFreeState;
    }

    public boolean getIsFree(){
        return this.isFree;
    }

    public void changeFreeState(){
        this.isFree = !this.isFree;
    }

}
