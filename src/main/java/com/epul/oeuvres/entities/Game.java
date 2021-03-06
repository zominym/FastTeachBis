package com.epul.oeuvres.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by sydne on 15/06/2016.
 */
@Entity
@Table(name = "GAME")
@XmlRootElement
public class Game implements Serializable {
    private static final long serialVersionUID = 1L;

    private int gameId;
    private String gameLabel;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GAME_ID")
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Basic
    @Column(name = "GAME_LABEL")
    public String getGameLabel() {
        return gameLabel;
    }

    public void setGameLabel(String gameLabel) {
        this.gameLabel = gameLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (gameId != game.gameId) return false;
        if (gameLabel != null ? !gameLabel.equals(game.gameLabel) : game.gameLabel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gameId;
        result = 31 * result + (gameLabel != null ? gameLabel.hashCode() : 0);
        return result;
    }
}
