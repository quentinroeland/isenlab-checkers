package fr.isen.checkers.core;

import fr.isen.checkers.core.board.BoardException;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Created by Quentin on 09/01/2017.
 */
public class CheckersGameTest {

    private CheckersGame checkersGame;

    @Before
    public void init(){
        checkersGame =  new CheckersGameImpl();
    }

    @Test
    public void gameIsInitTest(){
        checkersGame.init();
        assertThat(checkersGame.getBoardCell(0,0).equals(null));
        assertThat(checkersGame.getBoardCell(9,9).equals(null));
        assertThatExceptionOfType(BoardException.class).isThrownBy(() -> checkersGame.getBoardCell(10,10));
    }

    @Test
    public void movePawnTest(){
        //checkersGame.movePawn();
    }

    @Test
    public void moveLadieTest(){

    }

    @Test
    public void eatPawnTest(){

    }

    @Test
    public void isGameWonTest(){

    }
}
