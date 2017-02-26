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
    //
    	
    }


}
