package view;

import controller.EmployeController;
import controller.ProfessionnelController;
import controller.CreditController;
import controller.EcheanceController;
import controller.IncidentController;
import enums.DecisionEnum;
import model.Echeance;
import model.Employe;
import model.Professionnel;
import model.Credit;

import java.util.*;

public class Index {
    public Scanner reader;
    public Scanner readerCheffer;
    public EmployeView employeView;
    private ProfessionnelView professionnelView;
    private CreditView creditView;
    private EcheanceView echeanceView;
    private IncidentView incidentView;
    private ProfessionnelController professionnelController;
    private EmployeController employeController;
    private CreditController creditController;
    private EcheanceController echeanceController;
    private IncidentController incidentController;
    private String id = "";
    private String role;

    public Index() {
        reader = new Scanner(System.in);
        readerCheffer = new Scanner(System.in);
        employeView = new EmployeView();
        professionnelView = new ProfessionnelView();
        creditView = new CreditView();
        echeanceView = new EcheanceView();
        incidentView = new IncidentView();
        professionnelController = new ProfessionnelController();
        employeController = new EmployeController();
        creditController = new CreditController();
        echeanceController = new EcheanceController();
        incidentController = new IncidentController();
    }

    public void menuPrincipal() {
        System.out.println("================================================================");
        System.out.println("===\t\t\t**********\tMenu Principal\t**********");
        System.out.println("===\t1: Créer compte");
        System.out.println("===\t2: Accéder au compte");
        System.out.println("===\t3: Quitter");
        int choix;
        while (true) {
            try {
                System.out.print("===\t\tEntrez votre choix : ");
                choix = readerCheffer.nextInt();
                if (choix > 0 && choix < 4)
                    break;
                System.out.println(choix + " SVP entrez 1<=choix<=3 ");
            } catch (InputMismatchException e) {
                System.out.println("SVP entrez un entier");
                readerCheffer.nextLine();
            }
        }
        switch (choix) {
            case 1:
                menuAddPersonne();
                break;
            case 2:
                connected();
                break;
            case 3:
                System.out.println("Vous quittez l'application");
                System.exit(0);
                break;
        }
    }

    public void menuAddPersonne() {
        System.out.println("======================================================================");
        System.out.println("===\t\t\t**********  Créer Compte  **********");
        System.out.println("=== 1: Créer compte employé");
        System.out.println("=== 2: Créer compte professionnel");
        System.out.println("=== 3: Retour");
        System.out.println("=== 4: Quitter");
        int choix;
        while (true) {
            System.out.print("Entrez votre choix : ");
            try {
                choix = readerCheffer.nextInt();
                if (choix < 1 || choix > 4)
                    throw new IllegalArgumentException("Doit entrer une valeur entre 1 et 4");
                break;
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                readerCheffer.nextLine();
            }
        }
        switch (choix) {
            case 1:
                employeView.addEmploye();
                menuAddPersonne();
                break;
            case 2:
                professionnelView.addProfessionnel();
                menuAddPersonne();
                break;
            case 3:
                menuPrincipal();
                break;
            case 4:
                System.out.println("Vous quittez l'application");
                System.exit(0);
                break;
        }
    }

    public void connected() {
        boolean authenticated = false;

        while (!authenticated) {
            System.out.println("==============================================");
            System.out.print("=== Entrez votre ID : ");
            readerCheffer.nextLine();
            String idInput = readerCheffer.nextLine();

            Optional<Professionnel> opt = professionnelController.getProfessionnelById(idInput);
            Optional<Employe> emp = employeController.getEmployeById(idInput);

            if (opt.isPresent()) {
                role = "prof";
                this.id = opt.get().getId().toString();
                System.out.println("Connecté en tant que Professionnel");
                authenticated = true;
                profile();
            } else if (emp.isPresent()) {
                role = "emp";
                this.id = emp.get().getId().toString();
                System.out.println("Connecté en tant qu'Employé");
                authenticated = true;
                profile();
            } else {
                System.out.println("Aucun utilisateur trouvé avec cet ID. Veuillez réessayer.");
            }
        }
    }

    public void profile() {
        if (role.equals("emp")) {
            profileEmploye();
        } else if (role.equals("prof")) {
            profileProfessionnel();
        }
    }

    public void profileEmploye() {
        boolean continuer = true;
        while (continuer) {
            try {
                Optional<Employe> emp = employeController.getEmployeById(id);
                if (emp.isPresent()) {
                    System.out.println("======================= Bienvenue dans votre compte ===========================");
                    System.out.println("====== ID: " + this.id);
                    System.out.println("====== Type compte: Employé");
                    System.out.println("====== Nom: " + emp.get().getNom() + " " + emp.get().getPrenom());
                    System.out.println("*******************************************************************************");
                    System.out.println("==== 1: Créer crédit");
                    System.out.println("==== 2: Afficher les crédits");
                    System.out.println("==== 3: Afficher détails d'un crédit");
                    System.out.println("==== 4: Mettre à jour un crédit");
                    System.out.println("==== 5: Supprimer un crédit");
                    System.out.println("==== 6: Gérer les échéances");
                    System.out.println("==== 7: Gérer les incidents");
                    System.out.println("==== 8: Déconnexion");
                    System.out.println("==== 9: Quitter");

                    int choix;
                    do {
                        System.out.print("Entrez votre choix : ");
                        choix = readerCheffer.nextInt();
                    } while (choix < 1 || choix > 9);

                    switch (choix) {
                        case 1:
                            creditView.addCredit();
                            break;
                        case 2:
                            afficherTousLesCredits();
                            break;
                        case 3:
                            creditView.getCreditById();
                            break;
                        case 4:
                            updateCredit();
                            break;
                        case 5:
                            deleteCredit();
                            break;
                        case 6:
                            menuEcheances();
                            break;
                        case 7:
                            menuIncidents();
                            break;
                        case 8:
                            continuer = false;
                            menuPrincipal();
                            break;
                        case 9:
                            System.out.println("Vous quittez l'application");
                            System.exit(0);
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Erreur: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void profileProfessionnel() {
        boolean continuer = true;
        while (continuer) {
            Optional<Professionnel> prof = professionnelController.getProfessionnelById(id);
            if (prof.isPresent()) {
                System.out.println("======================= Bienvenue dans votre compte ===========================");
                System.out.println("====== ID: " + this.id);
                System.out.println("====== Type compte: Professionnel");
                System.out.println("====== Nom: " + prof.get().getNom() + " " + prof.get().getPrenom());
                System.out.println("*******************************************************************************");
                System.out.println("==== 1: Demander un crédit");
                System.out.println("==== 2: Afficher mes crédits");
                System.out.println("==== 3: Afficher détails d'un crédit");
                System.out.println("==== 4: Voir mes échéances");
                System.out.println("==== 5: Déconnexion");
                System.out.println("==== 6: Quitter");

                int choix;
                do {
                    System.out.print("Entrez votre choix : ");
                    choix = readerCheffer.nextInt();
                } while (choix < 1 || choix > 6);

                switch (choix) {
                    case 1:
                        creditView.addCredit();
                        break;
                    case 2:
                        afficherTousLesCredits();
                        break;
                    case 3:
                        creditView.getCreditById();
                        break;
                    case 4:
                        echeanceView.getAllEcheancesByCredit();
                        break;
                    case 5:
                        continuer = false;
                        menuPrincipal();
                        break;
                    case 6:
                        System.out.println("Vous quittez l'application");
                        System.exit(0);
                        break;
                }
            }
        }
    }

    public void menuEcheances() {
        boolean continuer = true;
        while (continuer) {
            System.out.println("===============================================");
            System.out.println("=== Menu Gestion des Échéances ===");
            System.out.println("=== 1: Ajouter une échéance");
            System.out.println("=== 2: Afficher les échéances d'un crédit");
            System.out.println("=== 3: Afficher une échéance");
            System.out.println("=== 4: Mettre à jour une échéance");
            System.out.println("=== 5: Supprimer une échéance");
            System.out.println("=== 6: Retour");

            int choix;
            do {
                System.out.print("Entrez votre choix : ");
                choix = readerCheffer.nextInt();
            } while (choix < 1 || choix > 6);

            switch (choix) {
                case 1:
                    echeanceView.addEcheance();
                    break;
                case 2:
                    echeanceView.getAllEcheancesByCredit();
                    break;
                case 3:
                    echeanceView.getEcheanceById();
                    break;
                case 4:
                    echeanceView.updateEcheance();
                    break;
                case 5:
                    echeanceView.deleteEcheance();
                    break;
                case 6:
                    continuer = false;
                    break;
            }
        }
    }

    public void menuIncidents() {
        boolean continuer = true;
        while (continuer) {
            System.out.println("===============================================");
            System.out.println("=== Menu Gestion des Incidents ===");
            System.out.println("=== 1: Ajouter un incident");
            System.out.println("=== 2: Mettre à jour un incident");
            System.out.println("=== 3: Supprimer un incident");
            System.out.println("=== 4: Retour");

            int choix;
            do {
                System.out.print("Entrez votre choix : ");
                choix = readerCheffer.nextInt();
            } while (choix < 1 || choix > 4);

            switch (choix) {
                case 1:
                    incidentView.addIncident();
                    break;
                case 2:
                    incidentView.updateIncident();
                    break;
                case 3:
                    incidentView.deleteIncident();
                    break;
                case 4:
                    continuer = false;
                    break;
            }
        }
    }

    public void afficherTousLesCredits() {
        System.out.println("===============================================");
        System.out.print("=== Entrer l'ID de la personne : ");
        readerCheffer.nextLine();
        String idPersonne = readerCheffer.nextLine();

        ArrayList<Credit> credits = creditController.getAllCreditByIDPersonne(idPersonne);

        if (credits.isEmpty()) {
            System.out.println("=== Aucun crédit trouvé pour cette personne");
        } else {
            System.out.println("=== Liste des crédits :");
            System.out.println("===============================================");
            for (Credit credit : credits) {
                System.out.println("--- ID: " + credit.getId());
                System.out.println("--- Date: " + credit.getDateDeCredit());
                System.out.println("--- Montant demandé: " + credit.getMontantDemande() + " DH");
                System.out.println("--- Montant octroyé: " + credit.getMontantOctroye() + " DH");
                System.out.println("--- Type: " + credit.getTypeCredit());
                System.out.println("--- Décision: " + credit.getDecision());
                System.out.println("===============================================");
            }
        }
    }

    public void updateCredit() {
        System.out.println("===============================================");
        System.out.println("=== Mettre à jour un crédit ===");
        System.out.print("=== Entrer l'ID du crédit : ");
        readerCheffer.nextLine();
        String idCredit = readerCheffer.nextLine();

        System.out.print("=== Entrer l'ID de la personne : ");
        String idPersonne = readerCheffer.nextLine();

        Optional<Credit> creditOpt = creditController.getCreditById(idCredit, idPersonne);

        if (creditOpt.isPresent()) {
            Credit credit = creditOpt.get();

            System.out.print("=== Nouveau montant demandé (actuel: " + credit.getMontantDemande() + ") : ");
            double montantDemande = readerCheffer.nextDouble();

            System.out.print("=== Nouveau montant octroyé (actuel: " + credit.getMontantOctroye() + ") : ");
            double montantOctroye = readerCheffer.nextDouble();

            System.out.print("=== Nouveau taux d'intérêt (actuel: " + credit.getTauxInteret() + ") : ");
            double tauxInteret = readerCheffer.nextDouble();

            System.out.print("=== Nouvelle durée en mois (actuel: " + credit.getDureeEnMois() + ") : ");
            int dureeEnMois = readerCheffer.nextInt();
            readerCheffer.nextLine();

            System.out.print("=== Nouvelle décision (actuel: " + credit.getDecision() + ") : ");
            String decision = readerCheffer.nextLine();

            credit.setMontantDemande(montantDemande);
            credit.setMontantOctroye(montantOctroye);
            credit.setTauxInteret(tauxInteret);
            credit.setDureeEnMois(dureeEnMois);
            credit.setDecision(DecisionEnum.valueOf(decision));

            creditController.updateCredit(credit);

            System.out.println("===============================================");
            System.out.println("=== Crédit mis à jour avec succès !");
            System.out.println("===============================================");
        } else {
            System.out.println("=== Crédit non trouvé !");
        }
    }

    public void deleteCredit() {
        System.out.println("===============================================");
        System.out.println("=== Supprimer un crédit ===");
        System.out.print("=== Entrer l'ID du crédit : ");
        readerCheffer.nextLine();
        String idCredit = readerCheffer.nextLine();

        System.out.print("=== Êtes-vous sûr de vouloir supprimer ce crédit ? (oui/non) : ");
        String confirmation = readerCheffer.nextLine();

        if (confirmation.equalsIgnoreCase("oui")) {
            creditController.deleteCredit(idCredit);
            System.out.println("===============================================");
            System.out.println("=== Crédit supprimé avec succès !");
            System.out.println("===============================================");
        } else {
            System.out.println("=== Suppression annulée");
        }
    }
}