package fr.isen.checkers.jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 23/01/2017.
 */

@Entity(name="GameEntity")
public class GameEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String token;

    @OneToMany(mappedBy="gameEntity", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @OrderColumn(name="index")
    private List<MoveEntity> moves = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<MoveEntity> getMoves() {
        return moves;
    }

    public void setMoves(List<MoveEntity> moves) {
        this.moves = moves;
    }

}
