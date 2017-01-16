package fr.isen.checkers.core.pawns;

import fr.isen.checkers.core.cell.Cell;

/**
 * Created by Quentin on 15/01/2017.
 */
public class Move {
    Direction direction;
    Cell destination;
    Boolean isMandatory;

    public Move(){
    }

    public Direction getDirection() {
        return direction;
    }

    public Cell getDestination() {
        return destination;
    }

    public Boolean getMandatory() {
        return isMandatory;
    }
}
