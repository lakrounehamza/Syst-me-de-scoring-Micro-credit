package view;

import java.util.*;

public class Index {
    public Scanner reader;
    public Scanner readerCheffer;

    public Index() {
        reader = new Scanner(System.in);
        readerCheffer = new Scanner(System.in);
    }

    public void menuPrancibale() {
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
                System.out.println(choix+"svp  entre  le 1<=choix<=3 ");
            } catch (InputMismatchException e) {
                System.out.println("svp  entre un entie");
                readerCheffer.nextLine();
            }
        }
        switch(choix){
            case 1:;
            case 2:;
            case 3:System.out.println("vous Quiter l'application ") ;break;
        }
    }
}
