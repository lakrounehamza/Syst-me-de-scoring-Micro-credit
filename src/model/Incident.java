package model;

import enums.TypeIncidentEnum;

import java.util.*;

public class Incident {
    private UUID id ;
    private Date dateIncident;
    private String echeance;
    private int score;
    private TypeIncidentEnum typeincident;

    public Incident( Date dateIncident, String echeance, int score, TypeIncidentEnum typeincident) {
        setId();
        this.dateIncident = dateIncident;
        this.echeance = echeance;
        this.score = score;
        this.typeincident = typeincident;
    }

    public Incident() {
        setId();
    }

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public Date getDateIncident() {
        return dateIncident;
    }

    public void setDateIncident(Date dateIncident) {
        this.dateIncident = dateIncident;
    }

    public String getEcheance() {
        return echeance;
    }

    public void setEcheance(String echeance) {
        this.echeance = echeance;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public TypeIncidentEnum getTypeincident() {
        return typeincident;
    }

    public void setTypeincident(TypeIncidentEnum typeincident) {
        this.typeincident = typeincident;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", dateIncident=" + dateIncident +
                ", echeance='" + echeance + '\'' +
                ", score=" + score +
                ", typeincident=" + typeincident ;
    }
}
