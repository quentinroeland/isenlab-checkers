package fr.isen.checkers.core.pawns;

import fr.isen.checkers.core.Player;
import fr.isen.checkers.core.Position;

/**
 * Created by Quentin on 15/01/2017.
 */
public abstract class Pawn {

    public Position position;
    public PawnColor color;

    public Pawn(Player player, Position position){
        this.position = position;
        this.color = player.getPawnColor();
    }
    public Position getPosition() {
        return position;
    }

    public PawnColor getColor() {
        return color;
    }

    public List<Move> getMoves(){
        //Not implemented yet
        return null;
    }
}
