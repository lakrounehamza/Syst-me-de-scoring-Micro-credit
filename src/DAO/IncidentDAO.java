package DAO;

import model.ConnectionDB;
import model.Incident;

import java.sql.*;

public class IncidentDAO {
    public  IncidentDAO(){}
    public void addIncident(Incident incident,String idEcheance){
        try(Connection  connection   = ConnectionDB.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("insert  into incidents   values(?,?,?,?,?,?)");
            stmt.setString(1,incident.getId().toString());
            stmt.setString(2,idEcheance);
            stmt.setDate(3, Date.valueOf(incident.getDateIncident().toString()));
            stmt.setString(4,incident.getEcheance());
            stmt.setInt(5,incident.getScore());
            stmt.setString(6,incident.getTypeincident().toString());
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
