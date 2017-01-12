package fr.isen.checkers.core.cell;

import fr.isen.checkers.core.PawnColor;

/**
 * Created by Quentin on 09/01/2017.
 */
public class Cell {

    private CellContent content;
    private CellColor color;

    public Cell(CellColor color){
        this.color = color;
    }

    public Cell(CellColor color, CellContent content){
        this.color = color;
        this.content = content;
    }

    public void setColor(CellColor cc){
        this.color = cc;
    }

    public CellColor getColor(){
        return this.color;
    }

    public void setContent(CellContent content) {
        this.content = content;
    }

    public CellContent getContent() {
        return content;
    }
}
