package fr.isen.checkers.core;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Quentin on 09/01/2017.
 */
public class CheckersGameTest {

    private CheckersGame checkersGame;

    @Before
    public void init(){
        checkersGame =  new CheckersGame();
    }

    @Test
    public void gameIsInitTest(){
        checkersGame.init();
        
    }

    @Test
    public void movePawnTest(){

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
