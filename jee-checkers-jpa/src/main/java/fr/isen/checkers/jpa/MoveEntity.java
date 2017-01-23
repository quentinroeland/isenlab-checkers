package fr.isen.checkers.jpa;

import javax.persistence.*;

/**
 * Created by Quentin on 23/01/2017.
 */

@Entity
public class MoveEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    @ManyToOne
    GameEntity gameEntity;

    @Column(name="origin_row")
    Integer originRow;

    @Column(name="origin_col")
    Integer originCol;

    @Column(name="destination_row")
    Integer destinationRow;

    @Column(name="destination_col")
    Integer destinationCol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GameEntity getGameEntity() {
        return gameEntity;
    }

    public void setGameEntity(GameEntity gameEntity) {
        this.gameEntity = gameEntity;
    }

    public Integer getOriginRow() {
        return originRow;
    }

    public void setOriginRow(Integer originRow) {
        this.originRow = originRow;
    }

    public Integer getOriginCol() {
        return originCol;
    }

    public void setOriginCol(Integer originCol) {
        this.originCol = originCol;
    }

    public Integer getDestinationRow() {
        return destinationRow;
    }

    public void setDestinationRow(Integer destinationRow) {
        this.destinationRow = destinationRow;
    }

    public Integer getDestinationCol() {
        return destinationCol;
    }

    public void setDestinationCol(Integer destinationCol) {
        this.destinationCol = destinationCol;
    }
}
