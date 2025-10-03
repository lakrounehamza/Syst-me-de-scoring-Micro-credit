package view;

import controller.IncidentController;
import model.Incident;
import enums.TypeIncidentEnum;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class IncidentView {
    public Scanner scanner = new Scanner(System.in);
    IncidentController incidentController = new IncidentController();

    public void addIncident(){
        System.out.println("===============================================");
        System.out.println("=== Ajouter un nouveau incident ===");

        System.out.print("=== Entrer l'ID de l'échéance : ");
        String idEcheance = scanner.nextLine();

        System.out.print("=== Date de l'incident (YYYY-MM-DD) : ");
        String dateStr = scanner.nextLine();

        System.out.print("=== Description de l'échéance : ");
        String echeance = scanner.nextLine();

        System.out.print("=== Score : ");
        int score = scanner.nextInt();
        scanner.nextLine();

        System.out.print("=== Type d'incident (RETARD_PAIEMENT/DEFAUT_PAIEMENT/AUTRE) : ");
        String typeIncidentStr = scanner.nextLine();

        try {
            LocalDate dateIncident = LocalDate.parse(dateStr);
            TypeIncidentEnum typeIncident = TypeIncidentEnum.valueOf(typeIncidentStr);

            Incident incident = new Incident(Date.valueOf(dateIncident), echeance, score, typeIncident);

            incidentController.addIncident(incident, idEcheance);

            System.out.println("===============================================");
            System.out.println("=== Incident ajouté avec succès !");
            System.out.println("===============================================");
        } catch (Exception e) {
            System.out.println("===============================================");
            System.out.println("=== Erreur lors de l'ajout de l'incident : " + e.getMessage());
            System.out.println("===============================================");
        }
    }

    public void updateIncident(){
        System.out.println("===============================================");
        System.out.println("=== Mettre à jour un incident ===");

        System.out.print("=== Entrer l'ID de l'incident : ");
        String id = scanner.nextLine();

        System.out.print("=== Nouvelle date de l'incident (YYYY-MM-DD) : ");
        String dateStr = scanner.nextLine();

        System.out.print("=== Nouvelle description de l'échéance : ");
        String echeance = scanner.nextLine();

        System.out.print("=== Nouveau score : ");
        int score = scanner.nextInt();
        scanner.nextLine();

        System.out.print("=== Nouveau type d'incident (RETARD_PAIEMENT/DEFAUT_PAIEMENT/AUTRE) : ");
        String typeIncidentStr = scanner.nextLine();

        try {
            LocalDate dateIncident = LocalDate.parse(dateStr);
            TypeIncidentEnum typeIncident = TypeIncidentEnum.valueOf(typeIncidentStr);

            Incident incident = new Incident(Date.valueOf(dateIncident), echeance, score, typeIncident);
            incident.setId(java.util.UUID.fromString(id));

            incidentController.updateIncident(incident);

            System.out.println("===============================================");
            System.out.println("=== Incident mis à jour avec succès !");
            System.out.println("===============================================");
        } catch (Exception e) {
            System.out.println("===============================================");
            System.out.println("=== Erreur lors de la mise à jour : " + e.getMessage());
            System.out.println("===============================================");
        }
    }

    public void deleteIncident(){
        System.out.println("===============================================");
        System.out.println("=== Supprimer un incident ===");

        System.out.print("=== Entrer l'ID de l'incident : ");
        String id = scanner.nextLine();

        System.out.print("=== Êtes-vous sûr de vouloir supprimer cet incident ? (oui/non) : ");
        String confirmation = scanner.nextLine();

        if(confirmation.equalsIgnoreCase("oui")){
            incidentController.deleteIncident(id);
            System.out.println("===============================================");
            System.out.println("=== Incident supprimé avec succès !");
            System.out.println("===============================================");
        } else {
            System.out.println("===============================================");
            System.out.println("=== Suppression annulée");
            System.out.println("===============================================");
        }
    }

    public void afficherIncident(Incident incident){
        System.out.println("===============================================");
        System.out.println("=== Détails de l'incident :");
        System.out.println("=== ID : " + incident.getId());
        System.out.println("=== Date : " + incident.getDateIncident());
        System.out.println("=== Échéance : " + incident.getEcheance());
        System.out.println("=== Score : " + incident.getScore());
        System.out.println("=== Type : " + incident.getTypeincident());
        System.out.println("===============================================");
    }
}