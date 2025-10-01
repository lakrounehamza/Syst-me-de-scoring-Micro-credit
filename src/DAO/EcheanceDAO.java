package DAO;

import model.ConnectionDB;
import model.Credit;
import model.Echeance;

import java.sql.Connection;
import java.sql.*;

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
    public void deleteEcheane(String id){
        try(Connection  connection   = ConnectionDB.getInstance().getConnection()){
            PreparedStatement  stmt  = connection.prepareStatement("delete from echeances where  id =?");
            stmt.setString(1,id);
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQL  erorr : "+e.getMessage());
        }
    }
    public  void  updateEcheane(Echeance echeance){
        try(Connection  connection   = ConnectionDB.getInstance().getConnection()){
            PreparedStatement  stmt  = connection.prepareStatement("update echeanes set dateecheance = ?, mensualite =?, datedepaiement=?, statutpaiement=? where  id =?");
            stmt.setDate(1, Date.valueOf(echeance.getDateecheance().toString()));
            stmt.setDouble(2, echeance.getMensualite());
            stmt.setDate(3, Date.valueOf(echeance.getDatedepaiement().toString()));
            stmt.setString(4, echeance.getStatutpaiement().toString());
            stmt.setString(5, echeance.getId().toString());

            stmt.executeUpdate();

        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
    }
}
