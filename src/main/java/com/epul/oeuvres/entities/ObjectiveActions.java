package com.epul.oeuvres.entities;

import javax.persistence.*;

/**
 * Created by sydne on 15/06/2016.
 */
@Entity
@Table(name = "objective_actions", schema = "test", catalog = "")
@IdClass(ObjectiveActionsPK.class)
public class ObjectiveActions {
    private int actionId;
    private int objectiveId;

    @Id
    @Column(name = "ACTION_ID")
    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    @Id
    @Column(name = "OBJECTIVE_ID")
    public int getObjectiveId() {
        return objectiveId;
    }

    public void setObjectiveId(int objectiveId) {
        this.objectiveId = objectiveId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjectiveActions that = (ObjectiveActions) o;

        if (actionId != that.actionId) return false;
        if (objectiveId != that.objectiveId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = actionId;
        result = 31 * result + objectiveId;
        return result;
    }
}
