package view;

import controller.EmployeController;
import model.Employe;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeView {
    public EmployeController employeController;
    public Scanner reader;

    public EmployeView() {
        employeController = new EmployeController();
        reader = new Scanner(System.in);
    }

    public void addEmploye() {
        String nom, prenom, ville, investissement, placement, situation_familiale, poste, secteur, typecontrat;
        LocalDate datedenaissance, anciennete;
        int nombreEnfants;
        double salaire;
        while (true) {
            try {
                System.out.print("Entrez votre nom : ");
                nom = reader.nextLine();
                if (nom.trim().length() < 3)
                    throw new IllegalArgumentException("doit  entre un nom contais des  caracter superier a 3");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Entrez votre prenom : ");
                prenom = reader.nextLine();
                if (prenom.trim().length() < 3)
                    throw new IllegalArgumentException("doit  entre un prenom contais des  caracter superier a 3");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.print("Entrez votre ville : ");
        ville = reader.nextLine();

        System.out.print("Entrez votre investissement : ");
        investissement = reader.nextLine();

        System.out.print("Entrez votre placement : ");
        placement = reader.nextLine();
        do {

                System.out.print("Entrez votre situation familiale \"Marie, celibataire\": ");
                situation_familiale = reader.nextLine();

        }while (!"Marie".equals(situation_familiale) && !"celibataire".equals(situation_familiale));

        System.out.print("Entrez votre poste : ");
        poste = reader.nextLine();

        System.out.print("Entrez votre secteur : ");
        secteur = reader.nextLine();
        do {
            System.out.print("Entrez votre type de contrat \"CDI , CDD\": ");
            typecontrat = reader.nextLine();
        }while (!typecontrat.equals("CDI") && !typecontrat.equals("CDD"));
//        while(true) {
//            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                System.out.print("Entrez votre date de naissance (dd/MM/yyyy) : ");
                datedenaissance = LocalDate.parse(reader.nextLine(), formatter);
                System.out.print("Entrez votre date d'embauche (dd/MM/yyyy) : ");
                anciennete = LocalDate.parse(reader.nextLine(), formatter);
//            }catch (){
//
//            }
//        }
        System.out.print("Entrez le nombre d'enfants : ");
        nombreEnfants = Integer.parseInt(reader.nextLine());

        System.out.print("Entrez votre salaire : ");
        salaire = Double.parseDouble(reader.nextLine());

        System.out.println("\n--- Informations Employé ---");
        System.out.println("Nom : " + nom);
        System.out.println("Prénom : " + prenom);
        System.out.println("Ville : " + ville);
        System.out.println("Investissement : " + investissement);
        System.out.println("Placement : " + placement);
        System.out.println("Situation familiale : " + situation_familiale);
        System.out.println("Poste : " + poste);
        System.out.println("Secteur : " + secteur);
        System.out.println("Type de contrat : " + typecontrat);
        System.out.println("Date de naissance : " + datedenaissance.format(formatter));
        System.out.println("Date d'embauche : " + anciennete.format(formatter));
        System.out.println("Nombre d'enfants : " + nombreEnfants);
        System.out.println("Salaire : " + salaire);
        Employe employe = new Employe(
                nom,
                prenom,
                datedenaissance,
                ville,
                nombreEnfants,
                investissement,
                placement,
                situation_familiale,
                LocalDate.now().toString(),
                0,
                salaire,
                anciennete,
                poste,
                typecontrat,
                secteur
        );
        System.out.println(employe);
        employeController.addEmploye(employe);
    }

}
