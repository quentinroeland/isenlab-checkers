package org.dmetzler.isen.puissance4.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;
import static org.dmetzler.isen.puissance4.core.ChipColour.WHITE;
import static org.dmetzler.isen.puissance4.core.ChipColour.BLACK;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by dmetzler on 03/09/2014.
 */
public class CheckersGameTest {

    private CheckersGame game;

    @Before
    public void doBefore() throws Exception {
        game = new CheckersGameImpl();
    }

    @Test
    public void gameInit() throws Exception {
      
        assertThat(game.getCell(0, 0)).isEqualTo(ChipColour.NULL);
        assertThat(game.getCell(0, 1)).isEqualTo(ChipColour.BLACK);
    }
    
    
    @Test
    public void gameMove() throws Exception{
    	game.play(1, 6, 2, 5);
    	assertThat(game.getCell(1, 6)).isEqualTo(ChipColour.NULL);
    	assertThat(game.getCell(2, 5)).isEqualTo(ChipColour.WHITE);
    	game.play(0, 3, 1, 4);
    	assertThat(game.getCell(0, 3)).isEqualTo(ChipColour.NULL);
    	assertThat(game.getCell(1, 4)).isEqualTo(ChipColour.BLACK);
    	game.play(2, 5, 0, 3);
    	assertThat(game.getCell(2, 5)).isEqualTo(ChipColour.NULL);
    	assertThat(game.getCell(1, 4)).isEqualTo(ChipColour.NULL);
    	assertThat(game.getCell(0, 3)).isEqualTo(ChipColour.WHITE);    	
    	
    }
    
    
    @Test
    public void gameWon() throws Exception{
    	assertThat(game.getWinner()).isEqualTo(ChipColour.NULL);
    	//TODO move to win
    	for(int i = 0 ; i < game.getRowsNumber(); i++){
    		for(int j = 0 ; j < game.getColumnsNumber(); j++){
        		game.setCell(j, i, ChipColour.NULL);
        	}
    	}
    	game.setCell(2, 1, ChipColour.BLACK);
    	game.setCell(3, 2, ChipColour.WHITE);
    	game.play(3, 2, 1, 0);
    	assertThat(game.getWinner()).isEqualTo(ChipColour.WHITE);
    }


}
