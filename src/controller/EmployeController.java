package controller;

import DAO.EmployeDAO;
import model.Employe;

import java.time.LocalDate;
import java.time.Period;

public class EmployeController {
    private EmployeDAO employeDAO;
    public EmployeController(){
       employeDAO = new  EmployeDAO ();
    }
    public void addEmploye(Employe employe){
        int score = 0;
        String typeContrat = employe.getTypecontrat();
        String secteur = employe.getSecteur();
        int anciennete = Period.between(employe.getAnciennete(), LocalDate.now()).getYears();
        if(typeContrat.equals("CDI") && secteur.equalsIgnoreCase("public")) {
            score += 25;
        } else if(typeContrat.equals("CDI") && secteur.equalsIgnoreCase("grande_entreprise")) {
            score += 15;
        } else if(typeContrat.equals("CDI") && secteur.equalsIgnoreCase("PME")) {
            score += 12;
        } else if(typeContrat.equals("CDD") || typeContrat.equalsIgnoreCase("Intérim")) {
            score += 10;
        } else if(typeContrat.equalsIgnoreCase("Profession_libérale")) {
            score += 18;
        } else if(typeContrat.equalsIgnoreCase("Auto-entrepreneur")) {
            score += 12;
        }
        if(anciennete >= 5) {
            score += 5;
        } else if(anciennete >= 2) {
            score += 3;
        } else if(anciennete >= 1) {
            score += 1;
        }
        double salaire = employe.getSalaire();
        if(salaire >= 10000) {
            score += 30;
        } else if(salaire >= 8000) {
            score += 25;
        } else if(salaire >= 5000) {
            score += 20;
        } else if(salaire >= 3000) {
            score += 15;
        } else {
            score += 10;
        }
        score += 10;
        int age = Period.between(employe.getDatedenaissance(), LocalDate.now()).getYears();
        String situation = employe.getSituation_familiale();
        int enfants = employe.getNombreEnfants();
        if(age >= 18 && age <= 25) score += 4;
        else if(age >= 26 && age <= 35) score += 8;
        else if(age >= 36 && age <= 55) score += 10;
        else if(age > 55) score += 6;
        if(situation.equalsIgnoreCase("Marié")) score += 3;
        else if(situation.equalsIgnoreCase("Célibataire")) score += 2;
        if(enfants == 0) score += 2;
        else if(enfants <= 2) score += 1;
        if(employe.getInvestissement() != null && !employe.getInvestissement().isEmpty()) score += 10;
        employe.setScore(score);
        employeDAO.addEmploye(employe);
    }
}
