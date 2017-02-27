package org.dmetzler.isen.puissance4.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.dmetzler.isen.puissance4.core.ChipColour;

@Entity
public class Turn {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;

    @ManyToOne
    Game game;

    @Column(name="srcCol")
    private int srcColumn;
    
    @Column(name="srcRow")
    private int srcRow;

    @Column(name="destCol")
    private int destColumn;
    
    @Column(name="destRow")
    private int destRow;
    
    

    public Turn() {

    }

	public Turn(Game game, int srcColumn, int srcRow, int destColumn, int destRow) {
		super();
		this.game = game;
		this.srcColumn = srcColumn;
		this.srcRow = srcRow;
		this.destColumn = destColumn;
		this.destRow = destRow;
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Game getGame() {
		return game;
	}



	public void setGame(Game game) {
		this.game = game;
	}



	public int getSrcColumn() {
		return srcColumn;
	}



	public void setSrcColumn(int srcColumn) {
		this.srcColumn = srcColumn;
	}



	public int getSrcRow() {
		return srcRow;
	}



	public void setSrcRow(int srcRow) {
		this.srcRow = srcRow;
	}



	public int getDestColumn() {
		return destColumn;
	}



	public void setDestColumn(int destColumn) {
		this.destColumn = destColumn;
	}



	public int getDestRow() {
		return destRow;
	}



	public void setDestRow(int destRow) {
		this.destRow = destRow;
	}




}
