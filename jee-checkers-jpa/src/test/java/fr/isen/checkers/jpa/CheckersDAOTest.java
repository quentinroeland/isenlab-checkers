package fr.isen.checkers.jpa;

import fr.isen.checkers.jpa.guice.GuiceRunner;
import fr.isen.checkers.jpa.guice.H2DBModule;
import fr.isen.checkers.jpa.guice.Modules;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Quentin on 23/01/2017.
 */

@RunWith(GuiceRunner.class)
@Modules({ H2DBModule.class, JPAModule.class })
public class CheckersDAOTest {

    @Inject
    EntityManager em;

    @Inject
    CheckersDAO dao;

    @Test
    public void daoIsInjected() throws Exception {
        assertThat(dao).isNotNull();
    }

    @Test
    public void itCanCreateAGame() throws Exception {
        CheckersAdapter game = dao.createNewGame();
        assertThat(game).isNotNull();

        String token = game.getToken();
        assertThat(game.getToken()).isNotNull();
        em.clear();
    }
}
