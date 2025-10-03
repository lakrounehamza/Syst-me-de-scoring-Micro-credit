package DAO;

import enums.StatutPaiementEnum;
import model.ConnectionDB;
import model.Credit;
import model.Echeance;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

public class EcheanceDAO {
    public EcheanceDAO() {
    }

    public void addEcheance(Echeance echeance, String idCredit) {
        String sql = "INSERT INTO echeances (id, idcredit, dateecheance, mensualite, datedepaiement, statutpaiement) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionDB.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, echeance.getId().toString());
            stmt.setString(2, idCredit);
            stmt.setDate(3, Date.valueOf(echeance.getDateecheance().toString()));
            stmt.setDouble(4, echeance.getMensualite());
            stmt.setDate(5, Date.valueOf(echeance.getDatedepaiement().toString()));
            stmt.setString(6, echeance.getStatutpaiement().toString());
            stmt.executeUpdate();
            System.out.println(" Échéance ajoutée avec succès !");
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        }
    }

    public void deleteEcheane(String id) {
        try (Connection connection = ConnectionDB.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("delete from echeances where  id =?");
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL  erorr : " + e.getMessage());
        }
    }

    public void updateEcheane(Echeance echeance) {
        try (Connection connection = ConnectionDB.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("update echeanes set dateecheance = ?, mensualite =?, datedepaiement=?, statutpaiement=? where  id =?");
            stmt.setDate(1, Date.valueOf(echeance.getDateecheance().toString()));
            stmt.setDouble(2, echeance.getMensualite());
            stmt.setDate(3, Date.valueOf(echeance.getDatedepaiement().toString()));
            stmt.setString(4, echeance.getStatutpaiement().toString());
            stmt.setString(5, echeance.getId().toString());

            stmt.executeUpdate();

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public ArrayList<Echeance> getAllEcheanceByCredit(String idCredit) {
        ArrayList<Echeance> array = new ArrayList<>();

        String sql = "SELECT echeances.id  dateecheance, mensualite, datedepaiement, statutpaiement " +
                "FROM echeances WHERE idcredit = ?";

        try (Connection connection = ConnectionDB.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, idCredit);
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                String idc = res.getString("id");
                Date dateEcheance = res.getDate("dateecheance");
                double mensualite = res.getDouble("mensualite");
                Date datePaiement = res.getDate("datedepaiement");
                StatutPaiementEnum statut = StatutPaiementEnum.valueOf(res.getString("statutpaiement"));
                Echeance echeance =new Echeance(dateEcheance, mensualite, datePaiement, statut);
                echeance.setId(UUID.fromString(idc));
                array.add(echeance);

            }

        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        }

        return array;
    }
}
