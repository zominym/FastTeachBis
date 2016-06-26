package com.epul.oeuvres.entities;

import javax.persistence.*;

/**
 * Created by sydne on 15/06/2016.
 */
@Entity
@Table(name = "TRAINING_GROUP")
@IdClass(TrainingGroupPK.class)
public class TrainingGroup {
    private int trainerId;
    private int traineeId;

    @Id
    @Column(name = "TRAINER_ID")
    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    @Id
    @Column(name = "TRAINEE_ID")
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

        TrainingGroup that = (TrainingGroup) o;

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
