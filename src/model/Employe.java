package model;

import java.util.*;

public class Employe  extends Personne{
    private double salaire ;
    private Date Anciennete;
    private String poste;
    private String typecontrat;
    private String secteur ;

    public Employe(String nom, String prenom, Date datedenaissance, String ville, int nombreEnfants, String investissement, String placement, String situation_familiale, String createdAt, int score, double salaire, Date anciennete, String poste, String typecontrat, String secteur) {
        super(nom, prenom, datedenaissance, ville, nombreEnfants, investissement, placement, situation_familiale, createdAt, score);
        this.salaire = salaire;
        Anciennete = anciennete;
        this.poste = poste;
        this.typecontrat = typecontrat;
        this.secteur = secteur;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public Date getAnciennete() {
        return Anciennete;
    }

    public void setAnciennete(Date anciennete) {
        Anciennete = anciennete;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getTypecontrat() {
        return typecontrat;
    }

    public void setTypecontrat(String typecontrat) {
        this.typecontrat = typecontrat;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }
    @Override
    public String toString() {
        return super.toString()+
                "salaire=" + salaire +
                ", Anciennete=" + Anciennete +
                ", poste='" + poste + '\'' +
                ", typecontrat='" + typecontrat + '\'' +
                ", secteur='" + secteur + '\'';
    }
}
