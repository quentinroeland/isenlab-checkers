package fr.isen.checkers.jpa;

import fr.isen.checkers.core.CheckersGame;
import fr.isen.checkers.core.CheckersGameImpl;
import fr.isen.checkers.core.Position;
import fr.isen.checkers.core.exceptions.MoveException;

/**
 * Created by Quentin on 23/01/2017.
 */
public class CheckersAdapter {

    private GameEntity gameEntity;

    private CheckersGame coreGame;

    private CheckersDAO dao;

    public CheckersAdapter(GameEntity gameEntity, CheckersDAO dao) throws MoveException {
        this.gameEntity = gameEntity;
        this.dao = dao;
        this.coreGame = new CheckersGameImpl();
        this.restoreGame();
    }

    public void restoreGame() throws MoveException {
        //restore Players

        //restore Board state from moves
        for(MoveEntity m : this.gameEntity.getMoves()){
            this.coreGame.move(
                    new Position(m.getOriginRow(), m.getOriginCol()),
                    new Position(m.getDestinationRow(), m.getDestinationCol()));
        }
    }

    public String getToken() {
        return this.gameEntity.getToken();
    }
}
