package view;

import controller.EcheanceController;
import model.Echeance;
import enums.StatutPaiementEnum;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class EcheanceView {
    public Scanner scanner = new Scanner(System.in);
    EcheanceController echeanceController = new EcheanceController();

    public void addEcheance(){
        System.out.println("===============================================");
        System.out.println("=== Ajouter une nouvelle échéance ===");

        System.out.print("=== Entrer l'ID du crédit : ");
        String idCredit = scanner.nextLine();

        System.out.print("=== Date d'échéance (YYYY-MM-DD) : ");
        String dateEcheanceStr = scanner.nextLine();

        System.out.print("=== Mensualité : ");
        double mensualite = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("=== Date de paiement (YYYY-MM-DD) : ");
        String datePaiementStr = scanner.nextLine();

        System.out.print("=== Statut de paiement (PAYE/NON_PAYE/EN_RETARD) : ");
        String statutStr = scanner.nextLine();

        try {
            Date dateEcheance = Date.valueOf(dateEcheanceStr);
            Date datePaiement = Date.valueOf(datePaiementStr);
            StatutPaiementEnum statut = StatutPaiementEnum.valueOf(statutStr);

            Echeance echeance = new Echeance(dateEcheance, mensualite, datePaiement, statut);

            echeanceController.addEcheance(echeance, idCredit);

            System.out.println("===============================================");
            System.out.println("=== Échéance ajoutée avec succès !");
            System.out.println("===============================================");
        } catch (Exception e) {
            System.out.println("===============================================");
            System.out.println("=== Erreur lors de l'ajout de l'échéance : " + e.getMessage());
            System.out.println("===============================================");
        }
    }

    public void updateEcheance(){
        System.out.println("===============================================");
        System.out.println("=== Mettre à jour une échéance ===");

        System.out.print("=== Entrer l'ID de l'échéance : ");
        String id = scanner.nextLine();

        System.out.print("=== Entrer l'ID du crédit : ");
        String idCredit = scanner.nextLine();

        Optional<Echeance> echeanceOpt = echeanceController.getEcheanceById(id, idCredit);

        if(echeanceOpt.isPresent()){
            Echeance echeance = echeanceOpt.get();

            System.out.print("=== Nouvelle date d'échéance (actuelle: " + echeance.getDateecheance() + ") (YYYY-MM-DD) : ");
            String dateEcheanceStr = scanner.nextLine();

            System.out.print("=== Nouvelle mensualité (actuelle: " + echeance.getMensualite() + ") : ");
            double mensualite = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("=== Nouvelle date de paiement (actuelle: " + echeance.getDatedepaiement() + ") (YYYY-MM-DD) : ");
            String datePaiementStr = scanner.nextLine();

            System.out.print("=== Nouveau statut (actuel: " + echeance.getStatutpaiement() + ") (PAYE/NON_PAYE/EN_RETARD) : ");
            String statutStr = scanner.nextLine();

            try {
                Date dateEcheance = Date.valueOf(dateEcheanceStr);
                Date datePaiement = Date.valueOf(datePaiementStr);
                StatutPaiementEnum statut = StatutPaiementEnum.valueOf(statutStr);

                echeance.setDateecheance(dateEcheance);
                echeance.setMensualite(mensualite);
                echeance.setDatedepaiement(datePaiement);
                echeance.setStatutpaiement(statut);

                echeanceController.updateEcheance(echeance);

                System.out.println("===============================================");
                System.out.println("=== Échéance mise à jour avec succès !");
                System.out.println("===============================================");
            } catch (Exception e) {
                System.out.println("===============================================");
                System.out.println("=== Erreur lors de la mise à jour : " + e.getMessage());
                System.out.println("===============================================");
            }
        } else {
            System.out.println("===============================================");
            System.out.println("=== Échéance non trouvée !");
            System.out.println("===============================================");
        }
    }

    public void deleteEcheance(){
        System.out.println("===============================================");
        System.out.println("=== Supprimer une échéance ===");

        System.out.print("=== Entrer l'ID de l'échéance : ");
        String id = scanner.nextLine();

        System.out.print("=== Êtes-vous sûr de vouloir supprimer cette échéance ? (oui/non) : ");
        String confirmation = scanner.nextLine();

        if(confirmation.equalsIgnoreCase("oui")){
            echeanceController.deleteEcheance(id);
            System.out.println("===============================================");
            System.out.println("=== Échéance supprimée avec succès !");
            System.out.println("===============================================");
        } else {
            System.out.println("===============================================");
            System.out.println("=== Suppression annulée");
            System.out.println("===============================================");
        }
    }

    public void getEcheanceById(){
        System.out.println("===============================================");
        System.out.print("=== Entrer l'ID de l'échéance : ");
        String id = scanner.nextLine();

        System.out.print("=== Entrer l'ID du crédit : ");
        String idCredit = scanner.nextLine();

        Optional<Echeance> echeanceOpt = echeanceController.getEcheanceById(id, idCredit);

        if(echeanceOpt.isPresent()){
            Echeance echeance = echeanceOpt.get();
            afficherEcheance(echeance);
        } else {
            System.out.println("===============================================");
            System.out.println("=== Aucune échéance trouvée avec cet ID !");
            System.out.println("===============================================");
        }
    }

    public void getAllEcheancesByCredit(){
        System.out.println("===============================================");
        System.out.print("=== Entrer l'ID du crédit : ");
        String idCredit = scanner.nextLine();

        ArrayList<Echeance> echeances = echeanceController.getAllEcheanceByCredit(idCredit);

        if(echeances.isEmpty()){
            System.out.println("===============================================");
            System.out.println("=== Aucune échéance trouvée pour ce crédit");
            System.out.println("===============================================");
        } else {
            System.out.println("===============================================");
            System.out.println("=== Liste des échéances :");
            System.out.println("===============================================");
            for(Echeance echeance : echeances){
                System.out.println("--- ID : " + echeance.getId());
                System.out.println("--- Date d'échéance : " + echeance.getDateecheance());
                System.out.println("--- Mensualité : " + echeance.getMensualite() + " DH");
                System.out.println("--- Date de paiement : " + echeance.getDatedepaiement());
                System.out.println("--- Statut : " + echeance.getStatutpaiement());
                System.out.println("===============================================");
            }
        }
    }

    public void afficherEcheance(Echeance echeance){
        System.out.println("===============================================");
        System.out.println("=== Détails de l'échéance :");
        System.out.println("=== ID : " + echeance.getId());
        System.out.println("=== Date d'échéance : " + echeance.getDateecheance());
        System.out.println("=== Mensualité : " + echeance.getMensualite() + " DH");
        System.out.println("=== Date de paiement : " + echeance.getDatedepaiement());
        System.out.println("=== Statut de paiement : " + echeance.getStatutpaiement());
        System.out.println("===============================================");
    }
}