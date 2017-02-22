package fr.isen.checkers.jpa;

import fr.isen.checkers.core.pawns.PawnColor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Player")
public class PlayerEntity {

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
	
	private String username;
	
	private PawnColor color;
	
	public PlayerEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public PlayerEntity(String username, PawnColor color){
		this.username = username;
		this.color = color;
	}
	
	public fr.isen.checkers.core.pawns.PawnColor getColor() {
		return color;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setColor(PawnColor color) {
		this.color = color;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
}
