package com.epul.oeuvres.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * Created by sydne on 15/06/2016.
 */
@Entity
@Table(name = "CALENDAR")
public class Calendar {
    private Date daydate;

    @Id
    @Column(name = "DAYDATE")
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

        Calendar calendar = (Calendar) o;

        if (daydate != null ? !daydate.equals(calendar.daydate) : calendar.daydate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return daydate != null ? daydate.hashCode() : 0;
    }
}
