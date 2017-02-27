package fr.isen.jeelab.checkers.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fr.isen.jeelab.checkers.core.ChipColour;
import fr.isen.jeelab.checkers.core.CheckersGame;
import fr.isen.jeelab.checkers.core.CheckersGameImpl;
import fr.isen.jeelab.checkers.jpa.CheckersAdapter;
import fr.isen.jeelab.checkers.jpa.CheckersDAO;

@Named("game")
@RequestScoped
public class CheckersBean implements Serializable {

    CheckersAdapter game ;

    @Inject
    CheckersDAO dao;


    public List<CheckersColumn> getColumns() {

        List<CheckersColumn> cols = new ArrayList<>();
        for (int i = 0; i < game.getColumnsNumber(); i++) {
            cols.add(new CheckersColumn(i, game));
        }
        return cols;

    }

    public void play(int srcCol, int srcRow, int destCol, int destRow) {
        game.play(srcCol, srcRow, destCol, destRow);

    }



    public void reset() {


    }

    public ChipColourWrapper getWinner() {
        if (game.getWinner() != null) {
            return new ChipColourWrapper(game.getWinner());
        } else {
            return null;
        }
    }

    public CheckersGame getGame() {
        return game;
    }

    public void createNewGame() {
        game = dao.createNewGame();

    }

    public String getToken() {
        return game.getToken();
    }

    public void loadFromToken(String token) {
        game = dao.loadFromToken(token);

    }

}
