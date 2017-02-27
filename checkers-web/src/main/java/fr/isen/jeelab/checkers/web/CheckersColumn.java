package fr.isen.jeelab.checkers.web;

import java.util.ArrayList;
import java.util.List;

import fr.isen.jeelab.checkers.core.ChipColour;
import fr.isen.jeelab.checkers.core.CheckersGame;

public class CheckersColumn {

    private int index;
    private CheckersGame game;

    public CheckersColumn(int i, CheckersGame game) {
        this.index = i;
        this.game = game;
    }

    public List<ChipColourWrapper> getCells() {
        List<ChipColourWrapper> cells = new ArrayList<>();
        for (int i = game.getRowsNumber() - 1; i >= 0; i--) {
            cells.add(new ChipColourWrapper(game.getCell(index, i)));
        }
        return cells;
    }

    public int getIndex() {
        return index;
    }

}
