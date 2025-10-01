package DAO;

import model.ConnectionDB;
import model.Employe;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class EmployeDAO {
    public EmployeDAO() {
    }

    public void addEmploye(Employe employe) {
        String sql = "CALL insert_employe(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = ConnectionDB.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, employe.getId().toString());
            stmt.setString(2, employe.getNom());
            stmt.setString(3, employe.getPrenom());
            stmt.setDate(4, Date.valueOf(employe.getDatedenaissance()));
            stmt.setString(5, employe.getVille());
            stmt.setInt(6, employe.getNombreEnfants());
            stmt.setString(7, employe.getInvestissement());
            stmt.setString(8, employe.getPlacement());
            stmt.setString(9, employe.getSituation_familiale());
            stmt.setInt(10, employe.getScore());
            stmt.setDouble(11, employe.getSalaire());
            stmt.setDate(12, Date.valueOf(employe.getAnciennete()));
            stmt.setString(13, employe.getPoste());
            stmt.setString(14, employe.getTypecontrat());
            stmt.setString(15, employe.getSecteur());

            stmt.executeUpdate();
            System.out.println("Employe est  insere !");
        } catch (SQLException e) {
            System.out.println(" Erreur SQL : " + e.getMessage());
        }
    }

    public void deleteEmploye(String idU) {
        try (Connection connection = ConnectionDB.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("delete from employes   where  id = ?");
            stmt.setString(1, idU);
            stmt.executeUpdate();
            System.out.println("delete   avec succes");
        } catch (SQLException exception) {
            System.out.println("SQL  error : " + exception.getMessage());
        }
    }

    public void updateEmploye(Employe newEmploye) {
        try (Connection connection = ConnectionDB.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(
                    "UPDATE employe SET nom = ?, prenom = ?, datedenaissance = ?, ville = ?, nombreEnfants = ?, " +
                            "investissement = ?, placement = ?, situation_familiale = ?, score = ?, salaire = ?, " +
                            "anciennete = ?, poste = ?, typecontrat = ?, secteur = ? WHERE id = ?"
            );

            stmt.setString(1, newEmploye.getNom());
            stmt.setString(2, newEmploye.getPrenom());
            stmt.setDate(3, Date.valueOf(newEmploye.getDatedenaissance()));
            stmt.setString(4, newEmploye.getVille());
            stmt.setInt(5, newEmploye.getNombreEnfants());
            stmt.setString(6, newEmploye.getInvestissement());
            stmt.setString(7, newEmploye.getPlacement());
            stmt.setString(8, newEmploye.getSituation_familiale());
            stmt.setInt(9, newEmploye.getScore());
            stmt.setDouble(10, newEmploye.getSalaire());
            stmt.setDate(11, Date.valueOf(newEmploye.getAnciennete()));
            stmt.setString(12, newEmploye.getPoste());
            stmt.setString(13, newEmploye.getTypecontrat());
            stmt.setString(14, newEmploye.getSecteur());
            stmt.setString(15, newEmploye.getId().toString());
            stmt.executeUpdate();
            System.out.println("updated  avec succes");
            stmt.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public ArrayList<Employe> getAllEmploye() {
        ArrayList<Employe> array = new ArrayList<>();
        try (Connection connection = ConnectionDB.getInstance().getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("select  p.* , e.salaire ,e.anciennete,e.poste,e.typecontrat,e.secteur   from  employes  e  join   persones  p   on   p.id=e.id");
            while (res.next()) {
                array.add(
                        new Employe(
                                res.getString("nom"),
                                res.getString("prenom"),
                                res.getDate("datedenaissance").toLocalDate(),
                                res.getString("ville"),
                                res.getInt("nombreEnfants"),
                                res.getString("investissement"),
                                res.getString("placement"),
                                res.getString("situation_familiale"),
                                res.getString("createdAt"),
                                res.getInt("score"),
                                res.getDouble("salaire"),
                                res.getDate("anciennete").toLocalDate(),
                                res.getString("poste"),
                                res.getString("typecontrat"),
                                res.getString("secteur")
                        )
                );
            }
        } catch (SQLException e) {

        }
        return array;
    }
}
