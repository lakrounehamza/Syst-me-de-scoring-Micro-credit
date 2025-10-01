package DAO;

import model.ConnectionDB;
import model.Credit;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreditDAO {
    public void addCredit(Credit credit ,String idPersonne) {
        try (Connection connection = ConnectionDB.getInstance().getConnection()) {
            String sql = "INSERT INTO credits " +
                    "(id, idpersonne, dateDeCredit, montantDemande, montantOctroye, " +
                    "tauxInteret, dureeEnMois, typeCredit, decision) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, credit.getId().toString());
            stmt.setString(2, idPersonne);
            stmt.setDate(3, Date.valueOf(credit.getDateDeCredit()));
            stmt.setDouble(4, credit.getMontantDemande());
            stmt.setDouble(5, credit.getMontantOctroye());
            stmt.setDouble(6, credit.getTauxInteret());
            stmt.setInt(7, credit.getDureeEnMois());
            stmt.setString(8, credit.getTypeCredit());
            stmt.setString(9, credit.getDecision());

            stmt.executeUpdate();
            System.out.println("Insertion avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        }
    }

}
