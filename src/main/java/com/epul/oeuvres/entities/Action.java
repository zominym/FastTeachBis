package com.epul.oeuvres.entities;

import javax.persistence.*;

/**
 * Created by sydne on 15/06/2016.
 */
@Entity
@Table(name = "ACTION")
public class Action {
    private int actionId;
    private String libaction;
    private Integer scoremin;
    private Integer successor;

    public void setScoremin(Integer scoremin) {
        this.scoremin = scoremin;
    }

    @Id
    @Column(name = "ACTION_ID")
    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    @Basic
    @Column(name = "LIBACTION")
    public String getLibaction() {
        return libaction;
    }

    public void setLibaction(String libaction) {
        this.libaction = libaction;
    }

    @Basic
    @Column(name = "SCOREMIN")
    public Integer getScoremin() {
        return (int) scoremin;
    }

    public void setScoremin(int scoremin) {
        this.scoremin = scoremin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Action action = (Action) o;

        if (actionId != action.actionId) return false;
        if (libaction != null ? !libaction.equals(action.libaction) : action.libaction != null) return false;
        if (scoremin != null ? !scoremin.equals(action.scoremin) : action.scoremin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = actionId;
        result = 31 * result + (libaction != null ? libaction.hashCode() : 0);
        result = 31 * result + (scoremin != null ? scoremin.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "SUCCESSOR")
    public Integer getSuccessor() {
        return successor;
    }

    public void setSuccessor(Integer successor) {
        this.successor = successor;
    }
}
