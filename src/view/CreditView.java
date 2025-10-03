package view;

import controller.CreditController;
import model.Credit;
import enums.DecisionEnum;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class CreditView {
    public Scanner scanner = new Scanner(System.in);
    CreditController creditController = new CreditController();

    public void addCredit(){
        System.out.println("===============================================");
        System.out.println("=== Ajouter un nouveau crédit ===");

        System.out.print("=== Entrer l'ID de la personne : ");
        String idPersonne = scanner.nextLine();

        System.out.print("=== Date de crédit (YYYY-MM-DD) : ");
        String dateStr = scanner.nextLine();

        System.out.print("=== Montant demandé : ");
        double montantDemande = scanner.nextDouble();

        System.out.print("=== Montant octroyé : ");
        double montantOctroye = scanner.nextDouble();

        System.out.print("=== Taux d'intérêt (%) : ");
        double tauxInteret = scanner.nextDouble();

        System.out.print("=== Durée en mois : ");
        int dureeEnMois = scanner.nextInt();
        scanner.nextLine();

        System.out.print("=== Type de crédit : ");
        String typeCredit = scanner.nextLine();

        System.out.print("=== Décision (APPROUVE/REFUSE/EN_ATTENTE) : ");
        String decisionStr = scanner.nextLine();

        try {
            LocalDate dateDeCredit = LocalDate.parse(dateStr);
            DecisionEnum decision = DecisionEnum.valueOf(decisionStr);

            Credit credit = new Credit(dateDeCredit, montantDemande, montantOctroye,
                    tauxInteret, dureeEnMois, typeCredit, decision);

            creditController.addCredit(credit, idPersonne);

            System.out.println("===============================================");
            System.out.println("=== Crédit ajouté avec succès !");
            System.out.println("===============================================");
        } catch (Exception e) {
            System.out.println("===============================================");
            System.out.println("=== Erreur lors de l'ajout du crédit : " + e.getMessage());
            System.out.println("===============================================");
        }
    }

    public void getCreditById(){
        System.out.println("===============================================");
        System.out.print("=== Entrer l'ID du crédit : ");
        String id = scanner.nextLine();

        System.out.print("=== Entrer l'ID de la personne : ");
        String idPersonne = scanner.nextLine();

        Optional<Credit> creditOptional = creditController.getCreditById(id, idPersonne);

        if(creditOptional.isPresent()){
            Credit credit = creditOptional.get();
            System.out.println("===============================================");
            System.out.println("=== Crédit trouvé :");
            System.out.println("=== ID : " + credit.getId());
            System.out.println("=== Date de crédit : " + credit.getDateDeCredit());
            System.out.println("=== Montant demandé : " + credit.getMontantDemande() + " DH");
            System.out.println("=== Montant octroyé : " + credit.getMontantOctroye() + " DH");
            System.out.println("=== Taux d'intérêt : " + credit.getTauxInteret() + " %");
            System.out.println("=== Durée en mois : " + credit.getDureeEnMois());
            System.out.println("=== Type de crédit : " + credit.getTypeCredit());
            System.out.println("=== Décision : " + credit.getDecision());
            System.out.println("===============================================");
        } else {
            System.out.println("===============================================");
            System.out.println("=== Aucun crédit trouvé avec cet ID !");
            System.out.println("===============================================");
        }
    }
}