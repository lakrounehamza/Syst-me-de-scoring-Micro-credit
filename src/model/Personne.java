package model;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.UUID;

public abstract class Personne {
    protected UUID id  ;
    protected  String nom  ;
    protected  String prenom;
    protected Date datedenaissance ;
    protected  String ville ;
    protected  int nombreEnfants;
    protected  String investissement;
    protected  String placement;
    protected  String situation_familiale;
    protected  String createdAt;
    protected  int score;

    public Personne( String nom, String prenom, Date datedenaissance, String ville, int nombreEnfants, String investissement, String placement, String situation_familiale, String createdAt, int score) {
        setId();
        this.nom = nom;
        this.prenom = prenom;
        this.datedenaissance = datedenaissance;
        this.ville = ville;
        this.nombreEnfants = nombreEnfants;
        this.investissement = investissement;
        this.placement = placement;
        this.situation_familiale = situation_familiale;
        this.createdAt = createdAt;
        this.score = score;
    }

    public void  setId(){
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDatedenaissance() {
        return datedenaissance;
    }

    public void setDatedenaissance(Date datedenaissance) {
        this.datedenaissance = datedenaissance;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getNombreEnfants() {
        return nombreEnfants;
    }

    public void setNombreEnfants(int nombreEnfants) {
        this.nombreEnfants = nombreEnfants;
    }

    public String getInvestissement() {
        return investissement;
    }

    public void setInvestissement(String investissement) {
        this.investissement = investissement;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    public String getSituation_familiale() {
        return situation_familiale;
    }

    public void setSituation_familiale(String situation_familiale) {
        this.situation_familiale = situation_familiale;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public String  toString(){
        return  "id =" + id +
                ", nom= '" + nom + '\'' +
                ", prenom= '" + prenom + '\'' +
                ", datedenaissance= " + datedenaissance +
                ", ville= '" + ville + '\'' +
                ", nombreEnfants= " + nombreEnfants +
                ", investissement= '" + investissement + '\'' +
                ", placement= '" + placement + '\'' +
                ", situation_familiale= '" + situation_familiale + '\'' +
                ", createdAt= '" + createdAt + '\'' +
                ", score= " + score;
    }
}
