package com.epul.oeuvres.entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by sydne on 15/06/2016.
 */
@Entity
@Table(name = "RESULT")
@IdClass(ResultPK.class)
public class Result {
    private Date daydate;
    private Integer score;
    private int registrationId;

    @Id
    @Column(name = "DAYDATE")
    public Date getDaydate() {
        return daydate;
    }

    public void setDaydate(Date daydate) {
        this.daydate = daydate;
    }

    @Basic
    @Column(name = "SCORE")
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (daydate != null ? !daydate.equals(result.daydate) : result.daydate != null) return false;
        if (score != null ? !score.equals(result.score) : result.score != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = registrationId;
        result = 31 * result + (daydate != null ? daydate.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }

    @Id
    @Column(name = "REGISTRATION_ID")
    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }
}
