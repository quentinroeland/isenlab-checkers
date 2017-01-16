package fr.isen.checkers.core;

/**
 * Created by Quentin on 15/01/2017.
 */
public class Position {
    private Integer rowIndex;
    private Integer colIndex;

    public Position(Integer rowI, Integer colI){
        this.rowIndex = rowI;
        this.colIndex = colI;
    }

    public Integer getColIndex() {
        return colIndex;
    }

    public Integer getRowIndex() {
        return rowIndex;
    }
}
