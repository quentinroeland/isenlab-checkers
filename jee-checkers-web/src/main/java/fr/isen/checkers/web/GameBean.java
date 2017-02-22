package fr.isen.checkers.web;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fr.isen.checkers.jpa.CheckersAdapter;
import fr.isen.checkers.jpa.CheckersDAO;

@Named("checkersgame")
@RequestScoped
public class GameBean implements Serializable{

	private CheckersAdapter adapter;
	
	@Inject
	CheckersDAO dao;
	
	public GameBean(){
	}
	
	public CheckersAdapter getAdapter(){
		return this.adapter;
	}
	
	public void createNewGame(){
		this.adapter = dao.createNewGame();
	}

}
