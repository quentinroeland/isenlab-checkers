package org.dmetzler.isen.puissance4.web;

import org.dmetzler.isen.puissance4.core.ChipColour;

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
