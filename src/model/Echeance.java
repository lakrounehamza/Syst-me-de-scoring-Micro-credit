package model;

import enums.StatutPaiementEnum;

import java.util.Date;
import java.util.UUID;

public class Echeance {
    private UUID id;
    private Date dateecheance;
    private double mensualité;
    private Date datedepaiement;
    private StatutPaiementEnum statutpaiement;
}
