package DAO;

import enums.DecisionEnum;
import model.ConnectionDB;
import model.Credit;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

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
    public  void upDateCredit(Credit   credit){
        try(Connection  connection  = ConnectionDB.getInstance().getConnection()){
            PreparedStatement stmt = connection.prepareStatement("update credits set dateDeCredit =? ,montantDemande=?,montantOctroye=?,tauxInteret=?,dureeEnMois=?,typeCredit=?,decision=? where  id = ?");
            stmt.setString(1,credit.getDateDeCredit().toString());
            stmt.setDouble(2,credit.getMontantDemande());
            stmt.setDouble(3,credit.getMontantOctroye());
            stmt.setDouble(4,credit.getTauxInteret());
            stmt.setInt(5,credit.getDureeEnMois());
            stmt.setString(6,credit.getTypeCredit());
            stmt.setString(7,credit.getDecision());
            stmt.executeUpdate();
            System.out.println("modification  avec succes !");
        }catch(SQLException  e){
            System.out.println("SQL  error "+e.getMessage());
        }
    }
    public void deleteCredit(String id){
        try(Connection  connection   = ConnectionDB.getInstance().getConnection()){
            PreparedStatement  stmt  = connection.prepareStatement("delete from credits where  id =?");
            stmt.setString(1,id);
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQL  erorr : "+e.getMessage());
        }
    }
    public ArrayList<Credit> getAllCreditByIDPersonne(String id) {
        ArrayList<Credit> list = new ArrayList<>();
        try (Connection connection = ConnectionDB.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT dateDeCredit, montantDemande, montantOctroye, tauxInteret, dureeEnMois, typeCredit, decision " +
                            "FROM credits WHERE idpersonne = ?"
            );
            stmt.setString(1, id);
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                LocalDate dateDeCredit = res.getDate("dateDeCredit").toLocalDate();
                double montantDemande = res.getDouble("montantDemande");
                double montantOctroye = res.getDouble("montantOctroye");
                double tauxInteret = res.getDouble("tauxInteret");
                int dureeEnMois = res.getInt("dureeEnMois");
                String typeCredit = res.getString("typeCredit");
                DecisionEnum decision = DecisionEnum.valueOf(res.getString("decision"));

                list.add(new Credit(dateDeCredit, montantDemande, montantOctroye, tauxInteret, dureeEnMois, typeCredit, decision));
            }
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        }

        return list;
    }
}
