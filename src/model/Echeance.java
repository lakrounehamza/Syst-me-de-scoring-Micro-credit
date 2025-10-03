package model;

import enums.StatutPaiementEnum;

import java.util.*;

public class Echeance {
    private UUID id;
    private Date dateecheance;
    private double mensualite;
    private Date datedepaiement;
    private StatutPaiementEnum statutpaiement;

    public Echeance() {
        setId();
    }

    public Echeance(Date dateecheance, double mensualite, Date datedepaiement, StatutPaiementEnum statutpaiement) {
        setId();
        this.dateecheance = dateecheance;
        this.mensualite = mensualite;
        this.datedepaiement = datedepaiement;
        this.statutpaiement = statutpaiement;
    }

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDateecheance() {
        return dateecheance;
    }

    public void setDateecheance(Date dateecheance) {
        this.dateecheance = dateecheance;
    }

    public double getMensualite() {
        return mensualite;
    }

    public void setMensualite(double mensualite) {
        this.mensualite = mensualite;
    }

    public Date getDatedepaiement() {
        return datedepaiement;
    }

    public void setDatedepaiement(Date datedepaiement) {
        this.datedepaiement = datedepaiement;
    }

    public StatutPaiementEnum getStatutpaiement() {
        return statutpaiement;
    }

    public void setStatutpaiement(StatutPaiementEnum statutpaiement) {
        this.statutpaiement = statutpaiement;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", dateecheance = " + dateecheance +
                        ", mensualite = " + mensualite +
                        ", datedepaiement = " + datedepaiement +
                        ", statutpaiement = " + statutpaiement
                ;
    }
}
