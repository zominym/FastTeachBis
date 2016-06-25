package com.epul.oeuvres.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by sydne on 15/06/2016.
 */
@Entity
public class Coefficient {
    private int coefficientId;
    private String indicLabel;
    private Integer weight;
    private int actionId;

    @Id
    @Column(name = "COEFFICIENT_ID")
    public int getCoefficientId() {
        return coefficientId;
    }

    public void setCoefficientId(int coefficientId) {
        this.coefficientId = coefficientId;
    }

    @Basic
    @Column(name = "INDIC_LABEL")
    public String getIndicLabel() {
        return indicLabel;
    }

    public void setIndicLabel(String indicLabel) {
        this.indicLabel = indicLabel;
    }

    @Basic
    @Column(name = "WEIGHT")
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coefficient that = (Coefficient) o;

        if (coefficientId != that.coefficientId) return false;
        if (indicLabel != null ? !indicLabel.equals(that.indicLabel) : that.indicLabel != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = coefficientId;
        result = 31 * result + (indicLabel != null ? indicLabel.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "ACTION_ID")
    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }
}
