package com.epul.oeuvres.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by sydne on 15/06/2016.
 */
public class ResultPK implements Serializable {
    private Date daydate;
    private int userId;
    private int registrationId;

    @Column(name = "DAYDATE")
    @Id
    public Date getDaydate() {
        return daydate;
    }

    public void setDaydate(Date daydate) {
        this.daydate = daydate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResultPK resultPK = (ResultPK) o;

        if (daydate != null ? !daydate.equals(resultPK.daydate) : resultPK.daydate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = registrationId;
        result = 31 * result + (daydate != null ? daydate.hashCode() : 0);
        return result;
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
