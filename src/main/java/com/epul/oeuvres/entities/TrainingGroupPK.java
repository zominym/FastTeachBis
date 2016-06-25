package com.epul.oeuvres.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by sydne on 15/06/2016.
 */
public class TrainingGroupPK implements Serializable {
    private int trainerId;
    private int traineeId;

    @Column(name = "TRAINER_ID")
    @Id
    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    @Column(name = "TRAINEE_ID")
    @Id
    public int getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(int traineeId) {
        this.traineeId = traineeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainingGroupPK that = (TrainingGroupPK) o;

        if (trainerId != that.trainerId) return false;
        if (traineeId != that.traineeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trainerId;
        result = 31 * result + traineeId;
        return result;
    }
}
