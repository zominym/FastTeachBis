package com.epul.oeuvres.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by sydne on 15/06/2016.
 */
@Entity
public class Objective {
    private int objectiveId;
    private String obectifLabel;
    private Integer totalScoreMin;
    private int missionId;

    @Id
    @Column(name = "OBJECTIVE_ID")
    public int getObjectiveId() {
        return objectiveId;
    }

    public void setObjectiveId(int objectiveId) {
        this.objectiveId = objectiveId;
    }

    @Basic
    @Column(name = "OBECTIF_LABEL")
    public String getObectifLabel() {
        return obectifLabel;
    }

    public void setObectifLabel(String obectifLabel) {
        this.obectifLabel = obectifLabel;
    }

    @Basic
    @Column(name = "TOTAL_SCORE_MIN")
    public Integer getTotalScoreMin() {
        return totalScoreMin;
    }

    public void setTotalScoreMin(Integer totalScoreMin) {
        this.totalScoreMin = totalScoreMin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Objective objective = (Objective) o;

        if (objectiveId != objective.objectiveId) return false;
        if (obectifLabel != null ? !obectifLabel.equals(objective.obectifLabel) : objective.obectifLabel != null)
            return false;
        if (totalScoreMin != null ? !totalScoreMin.equals(objective.totalScoreMin) : objective.totalScoreMin != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectiveId;
        result = 31 * result + (obectifLabel != null ? obectifLabel.hashCode() : 0);
        result = 31 * result + (totalScoreMin != null ? totalScoreMin.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "MISSION_ID")
    public int getMissionId() {
        return missionId;
    }

    public void setMissionId(int missionId) {
        this.missionId = missionId;
    }
}
