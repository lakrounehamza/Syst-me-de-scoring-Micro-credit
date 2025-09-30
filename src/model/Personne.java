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
}
