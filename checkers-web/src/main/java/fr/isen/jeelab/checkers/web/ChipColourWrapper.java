package fr.isen.jeelab.checkers.web;

import fr.isen.jeelab.checkers.core.ChipColour;

public class ChipColourWrapper {

    private ChipColour cell;

    public ChipColourWrapper(ChipColour cell) {
        this.cell = cell;
    }

    public String getCssColor() {
        if(ChipColour.WHITE == cell) {
            return "WHITE";
        } else if(ChipColour.BLACK ==cell) {
            return "BLACK";
        } else {
            return "NULL";
        }
    }

}
