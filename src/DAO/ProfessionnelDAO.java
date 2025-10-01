package DAO;

import model.ConnectionDB;
import model.Professionnel;

import java.sql.*;

public class ProfessionnelDAO {
    public ProfessionnelDAO() {
    }

    public void addProfessionnel(Professionnel professionnel) {
        try (Connection connection = ConnectionDB.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("CALL insert_personne_professionnel(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, professionnel.getId().toString());
            stmt.setString(2, professionnel.getNom());
            stmt.setString(3, professionnel.getPrenom());
            stmt.setDate(4, Date.valueOf(professionnel.getDatedenaissance()));
            stmt.setString(5, professionnel.getVille());
            stmt.setInt(6, professionnel.getNombreEnfants());
            stmt.setString(7, professionnel.getInvestissement());
            stmt.setString(8, professionnel.getPlacement());
            stmt.setString(9, professionnel.getSituation_familiale());
            stmt.setInt(10, professionnel.getScore());
            stmt.setDouble(11, professionnel.getRevenu());
            stmt.setString(12, professionnel.getImmatriculationfiscale());
            stmt.setString(13, professionnel.getSecteuractivite());
            stmt.setString(14, professionnel.getActivite());

            stmt.executeUpdate();
            System.out.println("insersion  avec  secces ");
        } catch (SQLException e) {
            System.out.println("SQL  erroe " + e.getMessage());
        }
    }
    public  void   deleteProfessionnel(String  id ){
        try(Connection  connection   = ConnectionDB.getInstance().getConnection()){
            PreparedStatement stmt  = connection.prepareStatement("delete   from   professionnels  whre  id  = ?");
            stmt.setString(1,id);
            stmt.executeUpdate();
        }catch(SQLException  exception){
            System.out.println(exception.getMessage());
        }
    }

}
