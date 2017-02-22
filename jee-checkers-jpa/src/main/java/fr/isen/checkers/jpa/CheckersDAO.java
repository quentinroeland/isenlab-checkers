package fr.isen.checkers.jpa;

import fr.isen.checkers.core.exceptions.MoveException;
import org.apache.commons.lang.RandomStringUtils;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.*;

/**
 * Created by Quentin on 23/01/2017.
 */

public class CheckersDAO {
	
	@Inject
    EntityManager em;

	@Inject
    UserTransaction ut;

    public CheckersAdapter createNewGame(){
        GameEntity game = new GameEntity();
        game.setToken(RandomStringUtils.randomAlphanumeric(10).toLowerCase());

        try {
            ut.begin();
            em.persist(game);
            ut.commit();

        } catch (NotSupportedException | SystemException | SecurityException
                | IllegalStateException | RollbackException
                | HeuristicMixedException | HeuristicRollbackException e) {
            return null;
        }
        try {
            return new CheckersAdapter(game, this);
        } catch (MoveException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void save(GameEntity ge){
        try{
            ut.begin();
            em.merge(ge);
            ut.commit();
        }
        catch (SecurityException | IllegalStateException | RollbackException
                | HeuristicMixedException | HeuristicRollbackException
                | SystemException | NotSupportedException e) {
            e.printStackTrace();
        }
    }

    private void persist(GameEntity ge){
        try{
            ut.begin();
            em.persist(ge);
            ut.commit();
        }
        catch (SecurityException | IllegalStateException | RollbackException
                | HeuristicMixedException | HeuristicRollbackException
                | SystemException | NotSupportedException e) {
            e.printStackTrace();
        }
    }
}
