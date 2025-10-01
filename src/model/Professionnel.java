package model;

import java.util.Date;

public class Professionnel extends Personne {
    private double revenu;
    private String immatriculationfiscale;
    private String secteuractivite;
    private String activite;

    public Professionnel(String nom, String prenom, Date datedenaissance, String ville, int nombreEnfants, String investissement, String placement, String situation_familiale, String createdAt, int score, String immatriculationfiscale, String secteuractivite, String activite) {
        super(nom, prenom, datedenaissance, ville, nombreEnfants, investissement, placement, situation_familiale, createdAt, score);
        this.immatriculationfiscale = immatriculationfiscale;
        this.secteuractivite = secteuractivite;
        this.activite = activite;
    }

    public double getRevenu() {
        return revenu;
    }

    public void setRevenu(double revenu) {
        this.revenu = revenu;
    }

    public String getImmatriculationfiscale() {
        return immatriculationfiscale;
    }

    public void setImmatriculationfiscale(String immatriculationfiscale) {
        this.immatriculationfiscale = immatriculationfiscale;
    }

    public String getSecteuractivite() {
        return secteuractivite;
    }

    public void setSecteuractivite(String secteuractivite) {
        this.secteuractivite = secteuractivite;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    @Override
    public String toString() {
        return super.toString() +
                "revenu=" + revenu +
                ", immatriculationfiscale='" + immatriculationfiscale + '\'' +
                ", secteuractivite='" + secteuractivite + '\'' +
                ", activite='" + activite + '\'' ;
    }
}
