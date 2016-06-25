package com.epul.oeuvres.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by sydne on 15/06/2016.
 */
public class GameMissionsPK implements Serializable {
    private int gameId;
    private int missionId;

    @Column(name = "GAME_ID")
    @Id
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Column(name = "MISSION_ID")
    @Id
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

        GameMissionsPK that = (GameMissionsPK) o;

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
