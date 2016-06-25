package com.epul.oeuvres.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by sydne on 15/06/2016.
 */
@Entity
public class Mission {
    private int missionId;
    private String missionLabel;

    @Id
    @Column(name = "MISSION_ID")
    public int getMissionId() {
        return missionId;
    }

    public void setMissionId(int missionId) {
        this.missionId = missionId;
    }

    @Basic
    @Column(name = "MISSION_LABEL")
    public String getMissionLabel() {
        return missionLabel;
    }

    public void setMissionLabel(String missionLabel) {
        this.missionLabel = missionLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mission mission = (Mission) o;

        if (missionId != mission.missionId) return false;
        if (missionLabel != null ? !missionLabel.equals(mission.missionLabel) : mission.missionLabel != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = missionId;
        result = 31 * result + (missionLabel != null ? missionLabel.hashCode() : 0);
        return result;
    }
}
