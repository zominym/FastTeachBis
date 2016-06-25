package com.epul.oeuvres.entities;

import javax.persistence.*;

/**
 * Created by sydney on 23/06/2016.
 */
@Entity
@Table(name = "REGISTRATION")
public class Registration {
    private int registrationId;
    private int gameId;
    private int traineeId;

    @Id
    @Column(name = "REGISTRATION_ID")
    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Registration that = (Registration) o;

        if (registrationId != that.registrationId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return registrationId;
    }

    @Basic
    @Column(name = "GAME_ID")
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Basic
    @Column(name = "TRAINEE_ID")
    public int getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(int traineeId) {
        this.traineeId = traineeId;
    }
}
