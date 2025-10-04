package view;

import java.util.*;

public class Index {
    public Scanner reader;
    public Scanner readerCheffer;
    public EmployeView  employeView;
    public Index() {
        reader = new Scanner(System.in);
        readerCheffer = new Scanner(System.in);
        employeView  = new EmployeView ();
    }

    public void menuPrincipal() {
        System.out.println("================================================================");
        System.out.println("===\t\t\t**********\tmenu prancibale\t**********");
        System.out.println("===\t1:create compte .");
        System.out.println("===\t2:acsered a compte .");
        System.out.println("===\t3:Quiter .");
        int choix;
        while (true) {
            try {
                System.out.print("===\t\t entre la choix : ");
                choix = readerCheffer.nextInt();
                if (choix > 0 && choix < 4)
                    break;
                System.out.println(choix + "svp  entre  le 1<=choix<=3 ");
            } catch (InputMismatchException e) {
                System.out.println("svp  entre un entie");
                readerCheffer.nextLine();
            }
        }
        switch (choix) {
            case 1:menuAddPersonne();break
                ;
            case 2:
                ;
            case 3:
                System.out.println("vous Quiter l'application ");
                break;
        }
    }

    public void menuAddPersonne() {
        System.out.println("======================================================================");
        System.out.println("===\t\t\t**********  create Compte  **********");
        System.out.println("=== 1: create compte employe");
        System.out.println("=== 2: create compte professionnel ");
        System.out.println("=== 3: return ");
        System.out.println("=== 4: Quiter");
        int choix;
        while (true) {
            System.out.print("entre  la choix : ");
            try {
                 choix = readerCheffer.nextInt();
                if (choix < 0 || choix > 5)
                    throw new IllegalArgumentException("doit  entre  un  value  entre 1 et 4");
                break;
            }catch(InputMismatchException  | IllegalArgumentException e){
                System.out.println(e.getMessage());
                readerCheffer.nextLine();
            }
        }
        switch (choix){
            case 1: employeView.addEmploye();break;
        }
    }

}
