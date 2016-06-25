package com.epul.oeuvres.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by sydne on 15/06/2016.
 */
public class ResultPK implements Serializable {
    private int learnerId;
    private Date daydate;
    private int actionId;
    private int userId;
    private int registrationId;

    @Column(name = "LEARNER_ID")
    @Id
    public int getLearnerId() {
        return learnerId;
    }

    public void setLearnerId(int learnerId) {
        this.learnerId = learnerId;
    }

    @Column(name = "DAYDATE")
    @Id
    public Date getDaydate() {
        return daydate;
    }

    public void setDaydate(Date daydate) {
        this.daydate = daydate;
    }

    @Column(name = "ACTION_ID")
    @Id
    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResultPK resultPK = (ResultPK) o;

        if (learnerId != resultPK.learnerId) return false;
        if (actionId != resultPK.actionId) return false;
        if (daydate != null ? !daydate.equals(resultPK.daydate) : resultPK.daydate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = learnerId;
        result = 31 * result + (daydate != null ? daydate.hashCode() : 0);
        result = 31 * result + actionId;
        return result;
    }

    @Column(name = "USER_ID")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "REGISTRATION_ID")
    @Id
    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }
}
