package org.dmetzler.isen.puissance4.jpa;

import java.math.BigDecimal;

import org.dmetzler.isen.puissance4.core.ChipColour;
import org.dmetzler.isen.puissance4.core.GameException;
import org.dmetzler.isen.puissance4.core.CheckersGame;
import org.dmetzler.isen.puissance4.core.CheckersGameImpl;

public class Puissance4Adapter implements CheckersGame {

    private Game game;

    private CheckersGame coreGame;

    private Puissance4DAO dao;

    public Puissance4Adapter(Puissance4DAO dao, Game game) {
        this.dao = dao;
        this.game = game;
        this.coreGame = new CheckersGameImpl();

        for (Turn turn : game.getTurns()) {
            this.coreGame.play(turn.getColour(), turn.getSrcColumn(), turn.getSrcRow(), turn.getDestColumn(), turn.getDestRow());
        }

    }

    @Override
    public void play(ChipColour colour, int srcColumn, int srcRow, int destColumn, int destRow) throws GameException {
        coreGame.play(colour, srcColumn,srcRow, destColumn, destRow);
        this.game.getTurns().add(new Turn(this.game, colour, srcColumn,srcRow, destColumn, destRow));
        switchTurn();

        dao.save(game);

    }

    private void switchTurn() {
        game.setCurrentTurn(game.getCurrentTurn() == ChipColour.WHITE ? ChipColour.BLACK
                : ChipColour.WHITE);

    }

    @Override
    public ChipColour getCell(int column, int row) {
        return coreGame.getCell(column, row);
    }

    @Override
    public int getColumnsNumber() {
        return coreGame.getColumnsNumber();
    }

    @Override
    public int getRowsNumber() {
        return coreGame.getRowsNumber();
    }

    @Override
    public ChipColour getWinner() {
        return coreGame.getWinner();
    }

    public String getToken() {
        return game.getToken();
    }

    public ChipColour getCurrentTurn() {
        return game.getCurrentTurn();
    }

}
