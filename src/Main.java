import DAO.EmployeDAO;
import model.Employe;
import  java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EmployeDAO  d  =  new EmployeDAO();
        LocalDate date = LocalDate.parse("2024-02-20");

        Employe e1 = new Employe(
                "Dupont",
                "Jean",
                LocalDate.parse("2024-02-20"),
                "Paris",
                2,
                "Immobilier",
                "Assurance Vie",
                "Marié",
                "2025-10-01",
                750,
                3500.75,
                 LocalDate.parse("2024-02-20"),
                "Développeur Senior",
                "CDI",
                "Informatique"
        );
//         System.out.println(e1.toString());
       // d.addEmploye(e1);
        d.deleteEmploye("f24b1050-32ba-4c11-ae3d-705ecfbea32a");
    }
}