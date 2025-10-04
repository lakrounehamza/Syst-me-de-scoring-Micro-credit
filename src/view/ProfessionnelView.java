package view;

import controller.ProfessionnelController;
import model.Professionnel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ProfessionnelView {
    private ProfessionnelController professionnelController;
    private Scanner reader;
    public  ProfessionnelView(){
        reader  = new Scanner(System.in);
        professionnelController  =  new ProfessionnelController();
    }
    public void addProfessionnel() {
        String nom, prenom, ville, investissement, placement, situation_familiale;
        String immatriculationFiscale, secteurActivite, activite;
        LocalDate datedenaissance;
        int nombreEnfants;

        while (true) {
            try {
                System.out.print("Entrez votre nom : ");
                nom = reader.nextLine();
                if (nom.trim().length() < 3)
                    throw new IllegalArgumentException("doit entre un nom contais des caracter superier a 3");
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
                    throw new IllegalArgumentException("doit entre un prenom contais des caracter superier a 3");
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
        } while (!"Marie".equals(situation_familiale) && !"celibataire".equals(situation_familiale));

        System.out.print("Entrez votre immatriculation fiscale : ");
        immatriculationFiscale = reader.nextLine();

        System.out.print("Entrez votre secteur d'activité : ");
        secteurActivite = reader.nextLine();

        System.out.print("Entrez votre activité : ");
        activite = reader.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("Entrez votre date de naissance (dd/MM/yyyy) : ");
        datedenaissance = LocalDate.parse(reader.nextLine(), formatter);

        System.out.print("Entrez le nombre d'enfants : ");
        nombreEnfants = Integer.parseInt(reader.nextLine());

        System.out.println("\n--- Informations Professionnel ---");
        System.out.println("Nom : " + nom);
        System.out.println("Prénom : " + prenom);
        System.out.println("Ville : " + ville);
        System.out.println("Investissement : " + investissement);
        System.out.println("Placement : " + placement);
        System.out.println("Situation familiale : " + situation_familiale);
        System.out.println("Immatriculation fiscale : " + immatriculationFiscale);
        System.out.println("Secteur d'activité : " + secteurActivite);
        System.out.println("Activité : " + activite);
        System.out.println("Date de naissance : " + datedenaissance.format(formatter));
        System.out.println("Nombre d'enfants : " + nombreEnfants);

        Professionnel professionnel = new Professionnel(
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
                immatriculationFiscale,
                secteurActivite,
                activite
        );

        System.out.println(professionnel);
        professionnelController.addProfessionnel(professionnel);
    }
}
