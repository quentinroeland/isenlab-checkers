package fr.isen.jeelab.checkers.jpa;

import fr.isen.jeelab.checkers.core.ChipColour;
import fr.isen.jeelab.checkers.jpa.guice.GuiceRunner;
import fr.isen.jeelab.checkers.jpa.guice.H2DBModule;
import fr.isen.jeelab.checkers.jpa.guice.Modules;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

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
        game = dao.loadFromToken(token);
        assertThat(game).isNotNull();
    }

    @Test
    public void itCanPlayWithAJPAGame() throws Exception {
        CheckersAdapter game = dao.createNewGame();

        Integer source_row = 6;
        Integer source_col = 1;
        Integer dest_row = 5;
        Integer dest_col = 2;

        game.play(source_col, source_row, dest_col, dest_row);

        assertThat(game.getCell(source_col, source_row)).isEqualTo(ChipColour.NULL);
        assertThat(game.getCell(dest_col, dest_row)).isEqualTo(ChipColour.WHITE);

        System.out.println(game.toString());

        String token = game.getToken();
        em.clear();
        game = dao.loadFromToken(token);
        assertThat(game).isNotNull();

        assertThat(game.getCell(source_col, source_row)).isEqualTo(ChipColour.NULL);
        assertThat(game.getCell(dest_col, dest_row)).isEqualTo(ChipColour.WHITE);
    }

}
