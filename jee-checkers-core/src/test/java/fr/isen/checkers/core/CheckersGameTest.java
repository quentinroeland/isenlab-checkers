package fr.isen.checkers.core;

import fr.isen.checkers.core.board.BoardException;
import fr.isen.checkers.core.cell.Cell;
import fr.isen.checkers.core.cell.CellColor;
import fr.isen.checkers.core.cell.CellContent;
import fr.isen.checkers.core.cell.CellContentType;
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
    }

    @Test
    public void gameIsInitTest(){
        Cell firstCell = checkersGame.getBoardCell(0, 1);
        assertThat(firstCell.getColor().equals(CellColor.Dark));
        CellContent firstCellContent = firstCell.getContent();
        assertThat(firstCellContent.getType().equals(CellContentType.PAWN));
        assertThat(firstCellContent.getColor().equals(PawnColor.BLACK));
        Cell lastCell = checkersGame.getBoardCell(9, 9);
        assertThat(lastCell.getColor().equals(CellColor.Light));
        CellContent lastCellContent = firstCell.getContent();
        assertThat(lastCellContent.getType().equals(CellContentType.EMPTY));
        assertThat(lastCellContent.getColor().equals(PawnColor.NULL));
        assertThatExceptionOfType(BoardException.class).isThrownBy(() -> checkersGame.getBoardCell(10,10));
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
