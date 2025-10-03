package DAO;

import model.ConnectionDB;
import model.Professionnel;

import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

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
    public void updateProfessionnel(Professionnel professionnel){
        try (Connection connection = ConnectionDB.getInstance().getConnection()) {
            String sql = "UPDATE professionnels SET nom = ?, prenom = ?, datedenaissance = ?, ville = ?, " +
                    "nombreEnfants = ?, investissement = ?, placement = ?, situation_familiale = ?, " +
                    "score = ?, revenu = ?, immatriculationfiscale = ?, secteuractivite = ?, activite = ? " +
                    "WHERE id = ?";

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, professionnel.getNom());
            stmt.setString(2, professionnel.getPrenom());
            stmt.setDate(3, Date.valueOf(professionnel.getDatedenaissance()));
            stmt.setString(4, professionnel.getVille());
            stmt.setInt(5, professionnel.getNombreEnfants());
            stmt.setString(6, professionnel.getInvestissement());
            stmt.setString(7, professionnel.getPlacement());
            stmt.setString(8, professionnel.getSituation_familiale());
            stmt.setInt(9, professionnel.getScore());
            stmt.setDouble(10, professionnel.getRevenu());
            stmt.setString(11, professionnel.getImmatriculationfiscale());
            stmt.setString(12, professionnel.getSecteuractivite());
            stmt.setString(13, professionnel.getActivite());
            stmt.setString(14, professionnel.getId().toString()); // clé primaire WHERE id = ?

            int rows = stmt.executeUpdate();
            System.out.println(rows + " ligne(s) mise(s) à jour");
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        }

    }
    public ArrayList<Professionnel> getAllProfessionnel() {
        ArrayList<Professionnel> list = new ArrayList<>();
        try (Connection connection = ConnectionDB.getInstance().getConnection()) {
            Statement stmt = connection.createStatement();

            String sql = "select p.* ,pr.revenu ,pr.immatriculationfiscale ,pr.secteuractivite ,pr.activite from professionnels pr join persones p on pr.id = p.id;";

            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                String  id = res.getString("id");
                Professionnel prof = new Professionnel(
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
                        res.getString("immatriculationfiscale"),
                        res.getString("secteuractivite"),
                        res.getString("activite")
                );
                prof.setId(UUID.fromString(id));
                list.add(prof);
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erreur SQL: " + e.getMessage());
        }
        return list;
    }

}
