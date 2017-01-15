package fr.isen.checkers.core;

import fr.isen.checkers.core.cell.Cell;
import fr.isen.checkers.core.cell.CellColor;
import fr.isen.checkers.core.exceptions.BoardException;
import fr.isen.checkers.core.pawns.PawnColor;
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
        this.checkersGame =  new CheckersGameImpl();
        this.checkersGame.init();
    }

    @Test
    public void gameIsInitTest(){
        Cell firstCell = checkersGame.getBoardCell(0, 0);
        assertThat(firstCell.getColor().equals(CellColor.Light));
        assertThat(firstCell.getPawn()).isNull();

        Cell firstCellWithPawn = checkersGame.getBoardCell(0,1);
        assertThat(firstCellWithPawn.getColor().equals(CellColor.Dark));
        assertThat(firstCellWithPawn.getPawn()).isNotNull();
        assertThat(firstCellWithPawn.getPawn().getColor().equals(PawnColor.BLACK));

        Cell lastCell = checkersGame.getBoardCell(9, 9);
        assertThat(lastCell.getColor().equals(CellColor.Light));
        assertThat(lastCell.getPawn()).isNull();

        assertThatExceptionOfType(BoardException.class).isThrownBy(() -> checkersGame.getBoardCell(10,10));

        Player p1 = checkersGame.getPlayer1();
        assertThat(p1.getPawns()).hasSize(20);

        Player p2 = checkersGame.getPlayer2();
        assertThat(p2.getPawns()).hasSize(20);

        checkersGame.displayGameBoard();
    }

    @Test
    public void movePawnTest(){
        //checkersGame.movePawn();
    }

    @Test
    public void moveKingTest(){

    }

    @Test
    public void eatPawnTest(){

    }

    @Test
    public void isGameWonTest(){

    }
}
