package fr.isen.jeelab.checkers.core;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckersGameTest {

    private CheckersGame game;

    @Before
    public void doBefore() throws Exception {
        game = new CheckersGameImpl();
    }

    @Test
    public void isInitialized() throws Exception {
    	//print game
		System.out.println(game.toString());

    	//Test first cells
		assertThat(game.getCell(0, 0)).isEqualTo(ChipColour.NULL);
        assertThat(game.getCell(1, 0)).isEqualTo(ChipColour.BLACK);
		assertThat(game.getCell(0, 1)).isEqualTo(ChipColour.BLACK);
		assertThat(game.getCell(1, 1)).isEqualTo(ChipColour.NULL);

		//Test last cells
		assertThat(game.getCell(9, 9)).isEqualTo(ChipColour.NULL);
		assertThat(game.getCell(8, 9)).isEqualTo(ChipColour.WHITE);
		assertThat(game.getCell(9, 8)).isEqualTo(ChipColour.WHITE);
		assertThat(game.getCell(8, 8)).isEqualTo(ChipColour.NULL);

		//Test number of row with pawns
		assertThat(game.getCell(0, 4)).isEqualTo(ChipColour.NULL);
		assertThat(game.getCell(1, 4)).isEqualTo(ChipColour.NULL);
		assertThat(game.getCell(2, 4)).isEqualTo(ChipColour.NULL);
		assertThat(game.getCell(3, 4)).isEqualTo(ChipColour.NULL);
		assertThat(game.getCell(0, 5)).isEqualTo(ChipColour.NULL);
		assertThat(game.getCell(1, 5)).isEqualTo(ChipColour.NULL);
		assertThat(game.getCell(2, 5)).isEqualTo(ChipColour.NULL);
		assertThat(game.getCell(3, 5)).isEqualTo(ChipColour.NULL);
    }
    
    @Test
    public void play() throws Exception{
    	Integer source_row = 6;
    	Integer source_col = 1;
    	Integer dest_row = 5;
    	Integer dest_col = 2;

		assertThat(game.getCell(source_col, source_row)).isEqualTo(ChipColour.WHITE);
		assertThat(game.getCell(dest_col, dest_row)).isEqualTo(ChipColour.NULL);

    	game.play(source_col, source_row, dest_col, dest_row);

		assertThat(game.getCell(source_col, source_row)).isEqualTo(ChipColour.NULL);
		assertThat(game.getCell(dest_col, dest_row)).isEqualTo(ChipColour.WHITE);

		System.out.println(game.toString());
    }

	@Test(expected = GameException.class)
	public void notYourTurn(){
		//Not your turn
		Integer src_row = 5;
		Integer src_col = 2;
		game.play(src_col, src_row, src_col+1, src_row-1);
	}

    @Test(expected = GameException.class)
	public void playOutOfBound(){
		//Play out of board
		Integer pawn_row = 2;
		Integer pawn_col = 9;
		game.play(pawn_col, pawn_row, pawn_col+1, pawn_row+1);
	}

	@Test(expected = GameException.class)
	public void playInTakenCell(){
		//Play in cell taken
		Integer pawn_row = 2;
		Integer pawn_col = 9;
		game.play(pawn_col, pawn_row, pawn_col-1, pawn_row+1);
	}

}
