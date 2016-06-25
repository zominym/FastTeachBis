package com.epul.oeuvres.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by sydne on 15/06/2016.
 */
public class ObjectiveActionsPK implements Serializable {
    private int actionId;
    private int objectiveId;

    @Column(name = "ACTION_ID")
    @Id
    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    @Column(name = "OBJECTIVE_ID")
    @Id
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

        ObjectiveActionsPK that = (ObjectiveActionsPK) o;

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
