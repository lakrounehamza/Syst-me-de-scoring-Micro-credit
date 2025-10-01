package model;

import enums.DecisionEnum;
import enums.TypeIncidentEnum;

import java.time.LocalDate;
import java.util.*;

public class Credit {
    private UUID id;
    private LocalDate dateDeCredit;
    private double montantDemande;
    private double montantOctroye;
    private double tauxInteret;
    private int dureeEnMois;
    private String typeCredit;
    private DecisionEnum decision;

    public Credit(LocalDate dateDeCredit, double montantDemande, double montantOctroye, double tauxInteret, int dureeEnMois, String typeCredit, DecisionEnum decision) {
        setId();
        this.dateDeCredit = dateDeCredit;
        this.montantDemande = montantDemande;
        this.montantOctroye = montantOctroye;
        this.tauxInteret = tauxInteret;
        this.dureeEnMois = dureeEnMois;
        this.typeCredit = typeCredit;
        this.decision = decision;
    }

    public Credit() {
        setId();
    }

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id =  UUID.randomUUID();
    }

    public LocalDate getDateDeCredit() {
        return dateDeCredit;
    }

    public void setDateDeCredit(LocalDate dateDeCredit) {
        this.dateDeCredit = dateDeCredit;
    }

    public double getMontantDemande() {
        return montantDemande;
    }

    public void setMontantDemande(double montantDemande) {
        this.montantDemande = montantDemande;
    }

    public double getMontantOctroye() {
        return montantOctroye;
    }

    public void setMontantOctroye(double montantOctroye) {
        this.montantOctroye = montantOctroye;
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public int getDureeEnMois() {
        return dureeEnMois;
    }

    public void setDureeEnMois(int dureeEnMois) {
        this.dureeEnMois = dureeEnMois;
    }

    public String getTypeCredit() {
        return typeCredit;
    }

    public void setTypeCredit(String typeCredit) {
        this.typeCredit = typeCredit;
    }

    public String getDecision() {
        return decision.toString();
    }

    public void setDecision(DecisionEnum decision) {
        this.decision = decision;
    }
    @Override
    public String toString() {
        return
                "id=" + id +
                ", dateDeCredit = " + dateDeCredit +
                ", montantDemande = " + montantDemande +
                ", montantOctroye = " + montantOctroye +
                ", tauxInteret = " + tauxInteret +
                ", dureeEnMois = " + dureeEnMois +
                ", typeCredit = '" + typeCredit + '\'' +
                ", decision = " + decision ;
    }

}
