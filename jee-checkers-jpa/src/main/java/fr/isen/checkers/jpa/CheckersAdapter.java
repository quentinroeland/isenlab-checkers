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
    	//init
    	this.coreGame.init();
   
        //restore Players
    	//PlayerEntity p1 = this.gameEntity.getPlayer1();
    	//PlayerEntity p2 = this.gameEntity.getPlayer2();
    	//this.coreGame.setPlayers(new Player(p1.getUsername(), p1.getColor()), new Player(p2.getUsername(), p2.getColor()));
    	
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
    
    public CheckersGame getCoreGame() {
		return coreGame;
	}
}
