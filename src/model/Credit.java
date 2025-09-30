package model;

import enums.DecisionEnum;
import enums.TypeIncidentEnum;

import java.util.*;

public class Credit {
    private UUID  id;
    private Date dateDeCredit;
    private double montantDemande;
    private double montantOctroye;
    private double tauxInteret;
    private int dureeEnMois;
    private String typeCredit;
    private DecisionEnum decision;
}
