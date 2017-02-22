package fr.isen.checkers.jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 23/01/2017.
 */

@NamedQueries({
    @NamedQuery(name = "GET_FROM_TOKEN", query = "SELECT g FROM Game g WHERE g.token = :token")
})
@Entity(name="Game")
public class GameEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String token;

    @OneToMany(mappedBy="gameEntity", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @OrderColumn(name="index")
    private List<MoveEntity> moves = new ArrayList<>();

    @OneToOne(cascade= CascadeType.ALL, fetch=FetchType.EAGER)
    private PlayerEntity player1;
    
    @OneToOne(cascade= CascadeType.ALL, fetch=FetchType.EAGER)
    private PlayerEntity player2;
    
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
    
    public void setPlayer1(PlayerEntity player1) {
		this.player1 = player1;
	}
    
    public void setPlayer2(PlayerEntity player2) {
		this.player2 = player2;
	}
    
    public PlayerEntity getPlayer1() {
		return player1;
	}
    
    public PlayerEntity getPlayer2() {
		return player2;
	}

}
