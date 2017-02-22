package fr.isen.checkers.web;

import fr.isen.checkers.core.CheckersGameImpl;
import fr.isen.checkers.core.Player;
import fr.isen.checkers.core.board.Board;
import fr.isen.checkers.core.pawns.PawnColor;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("game")
@Produces({"application/json", "text/xml"})
public class GameService {
		
	@Inject
	private GameBean bean;
	 
	@GET
	@Path("/player")
	public Player getPlayer(){
		return new Player("Quentin", PawnColor.BLACK);
	}
	
	@GET
	@Path("/board")
	public Board getBoard(){
 		CheckersGameImpl game = new CheckersGameImpl();
		game.init();
		return game.getBoard();
		
	}
}
