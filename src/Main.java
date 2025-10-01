import DAO.EmployeDAO;
import DAO.ProfessionnelDAO;
import model.Employe;
import model.Professionnel;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EmployeDAO d = new EmployeDAO();
        LocalDate date = LocalDate.parse("2024-02-20");

//        Employe e1 = new Employe(
//                "Dupont",
//                "Jean",
//                LocalDate.parse("2024-02-20"),
//                "Paris",
//                2,
//                "Immobilier",
//                "Assurance Vie",
//                "Marié",
//                "2025-10-01",
//                750,
//                3500.75,
//                 LocalDate.parse("2024-02-20"),
//                "Développeur Senior",
//                "CDI",
//                "Informatique"
//        );

//         System.out.println(e1.toString());

        //d.addEmploye(e1);
        // d.deleteEmploye("f24b1050-32ba-4c11-ae3d-705ecfbea32a");
        //d.getAllEmploye().forEach(employe -> System.out.println(employe.toString()));
        ProfessionnelDAO  pro =  new ProfessionnelDAO();
        Professionnel pro1 = new Professionnel(
                "dupont",
                "Jean",
                LocalDate.parse("2024-02-20"),
                "Paris",
                2,
                "Immobilier",
                "Assurance Vie",
                "Marié",
                "2025-10-01",
                750,
                "FR123456789",
                "Informatique",
                "Développement logiciel"
        );
        System.out.println(pro1);
        pro.addProfessionnel(pro1);
    }
}