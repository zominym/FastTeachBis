package com.epul.oeuvres.entities;

import javax.persistence.*;

/**
 * Created by sydne on 15/06/2016.
 */
@Entity
@Table(name = "GAME_MISSIONS")
@IdClass(GameMissionsPK.class)
public class GameMissions {
    private int gameId;
    private int missionId;

    @Id
    @Column(name = "GAME_ID")
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Id
    @Column(name = "MISSION_ID")
    public int getMissionId() {
        return missionId;
    }

    public void setMissionId(int missionId) {
        this.missionId = missionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameMissions that = (GameMissions) o;

        if (gameId != that.gameId) return false;
        if (missionId != that.missionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gameId;
        result = 31 * result + missionId;
        return result;
    }
}
