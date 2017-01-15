package fr.isen.checkers.core.cell;

import fr.isen.checkers.core.PawnColor;

/**
 * Created by maxim on 12/01/2017.
 */
public class CellContent {

    private CellContentType type;
    private PawnColor color;

    public CellContent(CellContentType type, PawnColor color) {
        this.type = type;
        this.color = color;
    }

    public CellContentType getType() {
        return type;
    }

    public void setType(CellContentType type) {
        this.type = type;
    }

    public PawnColor getColor() {
        return color;
    }

    public void setColor(PawnColor color) {
        this.color = color;
    }
}
