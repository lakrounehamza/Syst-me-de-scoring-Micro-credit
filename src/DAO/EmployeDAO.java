package DAO;

import model.ConnectionDB;
import model.Employe;
import  java.sql.*;
public class EmployeDAO {
    public void  add(Employe employe){
        try(Connection  connection  = ConnectionDB.getInstance().getConnection()){

        }catch(SQLException e){
            System.out.println("SQL Erorr");
        }
    }
}
