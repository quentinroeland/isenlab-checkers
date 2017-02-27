package org.dmetzler.isen.puissance4.core;

import java.util.ArrayList;
import java.util.List;
import org.dmetzler.isen.puissance4.*;

/**
 * Created by dmetzler on 03/09/2014.
 */
public class CheckersGameImpl implements CheckersGame {

    public static final int COLUMNS_NUMBER = 10;
    public static final int ROWS_NUMBER = 10;
    public static final int NUMBER_OF_CHIP_TO_ALIGN = 4;
    public static final String OUTSIDE_OF_BOARD_ERROR = "It is not possible to play outside of the board";
    public static final String CASE_EMPTY = "The case you picked is empty";
    public static final String CASE_NOT_EMPTY= "The case you picked is not empty";
    public static final String WRONG_WAY= "You're going the wrong way";
    public static final String WRONG_PLAYER= "It's not your turn";
    
    private ChipColour winner = ChipColour.NULL;
    private ChipColour playerTurn = ChipColour.WHITE;
    
    
    List<List<ChipColour>> board = new ArrayList<>();

    public CheckersGameImpl() {
        initBoard();
    }

    private void initBoard() {
        setupPawnsPlayer(ChipColour.BLACK, 0, 3);
        for(int rowIndex = 4; rowIndex < 6 ; rowIndex++){
        	 List<ChipColour> row = new ArrayList<ChipColour>();
             for (int colIndex = 0  ; colIndex < COLUMNS_NUMBER ;colIndex++) {
                 row.add(ChipColour.NULL);
             }
             this.board.add(row);
        }
        setupPawnsPlayer(ChipColour.WHITE, 6, 9);
    }
    
    private void setupPawnsPlayer(ChipColour player, Integer rowBegin, Integer rowEnd) {
        for (int rowIndex = rowBegin; rowIndex <= rowEnd; rowIndex++) {
            List<ChipColour> row = new ArrayList<ChipColour>();
 
            for (int colIndex = 0  ; colIndex < COLUMNS_NUMBER ;colIndex++) {
            	ChipColour cell;
                if (hasPawnAtInit(rowIndex, colIndex)) {
                    cell = player;
                }else{
                	cell = ChipColour.NULL;
                }
                row.add(cell);
            }
            this.board.add(row);
        }   
    }
    
    private boolean hasPawnAtInit(int row, int col) {
        Boolean response = false;
        Integer rowModule = row % 2;
        Integer colModule = col % 2;
        if (rowModule == 0) {
            if (colModule != 0) {
                response = true;
            }
        } else {
            if (colModule == 0) {
               response = true;
            }
        }
        return response;
    }


    @Override
    public void play(int srcColumn, int srcRow, int destColumn, int destRow) {
        if (srcColumn > getColumnsNumber() - 1 || srcRow > getRowsNumber() -1 ||
        	destColumn > getColumnsNumber() -1 || destRow > getRowsNumber() -1 )
        {
            throw new GameException(OUTSIDE_OF_BOARD_ERROR);
        }
        ChipColour currentPlayer = this.getCell(srcColumn, srcRow);
        if(currentPlayer == ChipColour.NULL){
        	throw new GameException(CASE_EMPTY);
        }else{
        	if(currentPlayer != playerTurn){
        		throw new GameException(WRONG_PLAYER);
        	}
        	ChipColour destCase = this.getCell( destColumn, destRow);
        	if(destCase != ChipColour.NULL){
        		throw new GameException(CASE_NOT_EMPTY);
        	}
        	if(currentPlayer == ChipColour.BLACK){
        		playBlack(srcColumn, srcRow,  destColumn,  destRow);
        	}else{
        		playWhite(srcColumn, srcRow,  destColumn,  destRow);
        	}
        }
        changePlayerTurn();
    }

    
    private void changePlayerTurn() {
        if(this.playerTurn == ChipColour.WHITE){
        	this.playerTurn = ChipColour.BLACK;	
        }else{
        	this.playerTurn = ChipColour.WHITE;	
        }
	}

	//Going Down
    public void playBlack(int srcColumn, int srcRow, int  destColumn, int  destRow){
    	if(destRow < srcRow){
    		throw new GameException(WRONG_WAY);
    	}
    	//Cas simple deplacement a une case
    	if(srcRow == destRow -1 && ((srcColumn == destColumn +1) ||(srcColumn == destColumn -1))){
    			this.setCell(srcColumn, srcRow, ChipColour.NULL);
    			this.setCell(destColumn, destRow, ChipColour.BLACK);
    	}
    	//Prise Simple
    	if(srcRow == destRow -2 && ((srcColumn == destColumn +2) ||(srcColumn == destColumn -2))){
			this.setCell( srcColumn, srcRow, ChipColour.NULL);
			if(srcColumn < destColumn){
				//Prise simple a droite
				this.setCell(srcColumn +1, srcRow +1, ChipColour.NULL);
			}else{
				//Prise simple a gauche
				this.setCell( srcColumn -1, srcRow +1, ChipColour.NULL);
			}
			this.setCell(destColumn, destRow,  ChipColour.BLACK);
    	}
    	
    	//TODO prise complexe (plus qu'un pion)
    	
    	if(destRow == this.ROWS_NUMBER -1 ){
    		this.winner = ChipColour.BLACK;
    	}
    }
    
    //Going UP
    public void playWhite(int srcColumn, int srcRow, int  destColumn, int  destRow){
    	if(destRow > srcRow){
    		throw new GameException(WRONG_WAY);
    	}
    	if(srcRow == destRow +1 && ((srcColumn == destColumn +1) ||(srcColumn == destColumn -1))){
			this.setCell(srcColumn,srcRow, ChipColour.NULL);
			this.setCell(destColumn, destRow,ChipColour.WHITE);
    	}
    	if(srcRow == destRow +2 && ((srcColumn == destColumn +2) ||(srcColumn == destColumn -2))){
			this.setCell(srcColumn, srcRow, ChipColour.NULL);
			if(srcColumn < destColumn){
				//Prise simple a droite
				this.setCell(srcColumn +1, srcRow -1, ChipColour.NULL);
			}else{
				//Prise simple a gauche
				this.setCell(srcColumn -1, srcRow -1, ChipColour.NULL);
			}
			this.setCell(destColumn,destRow,  ChipColour.WHITE);
    	}
    	
    	//TODO prise complexe (plus qu'un pion)
    	
    	if(destRow == 0 ){
    		this.winner = ChipColour.WHITE;
    	}
    }
    
    @Override
    public ChipColour getCell(int colIndex, int rowIndex) {
        if (rowIndex < 0 || rowIndex >= getColumnsNumber()) {
            return null;
        }
        List<ChipColour> row = board.get( rowIndex);
        return colIndex < row.size() && colIndex >= 0 ? row.get(colIndex) : null;
    }
    
    @Override
    public void setCell(int colIndex , int rowIndex, ChipColour cp){
    	List<ChipColour> row = board.get(rowIndex);
        row.set(colIndex, cp);
    }

    @Override
    public int getColumnsNumber() {
        return COLUMNS_NUMBER;
    }

    @Override
    public int getRowsNumber() {
        return ROWS_NUMBER;
    }

    @Override
    public ChipColour getWinner() {
        return this.winner;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= getRowsNumber() - 1; i++) {
            sb.append("|");
            for (int j = 0; j < getColumnsNumber(); j++) {
                if (getCell(j, i) == ChipColour.WHITE) {
                    sb.append("O");
                } else if (getCell(j, i) == ChipColour.BLACK) {
                    sb.append("X");
                } else {
                    sb.append(" ");
                }
                sb.append("|");
            }
            sb.append("\n");
        }
        for (int i = 0; i < getRowsNumber() * 2 + 3; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
