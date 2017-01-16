package fr.isen.checkers.core;

import fr.isen.checkers.core.pawns.Pawn;
import fr.isen.checkers.core.pawns.PawnColor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 15/01/2017.
 */
public class Player {

    private String name;
    private PawnColor pawnColor;
    private List<Pawn> pawns;

    public Player(){
        this.pawns = new ArrayList<>();
    }
    public Player(String name, PawnColor color){
        this();
        this.name = name;
        this.pawnColor = color;
    }

    public String getName() {
        return name;
    }

    public PawnColor getPawnColor() {
        return pawnColor;
    }

    public List<Pawn> getPawns() {
        return pawns;
    }

    public void addPawn(Pawn pawn) {
        this.pawns.add(pawn);
    }
}
