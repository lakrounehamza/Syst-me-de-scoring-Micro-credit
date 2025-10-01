package DAO;

import model.ConnectionDB;
import model.Employe;
import  java.sql.*;
public class EmployeDAO {
    public  EmployeDAO(){}
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

}
