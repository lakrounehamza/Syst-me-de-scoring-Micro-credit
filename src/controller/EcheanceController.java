package controller;

import DAO.EcheanceDAO;
import model.Echeance;
import java.util.*;
import java.util.function.*;

public class EcheanceController {
    public EcheanceDAO echeanceDAO;

    public EcheanceController(){
        echeanceDAO = new EcheanceDAO();
    }

    public void addEcheance(Echeance echeance, String idCredit){
        echeanceDAO.addEcheance(echeance, idCredit);
    }

    public void updateEcheance(Echeance echeance){
        echeanceDAO.updateEcheane(echeance);
    }

    public void deleteEcheance(String id){
        echeanceDAO.deleteEcheane(id);
    }

    public ArrayList<Echeance> getAllEcheanceByCredit(String idCredit){
        return echeanceDAO.getAllEcheanceByCredit(idCredit);
    }

    public Optional<Echeance> getEcheanceById(String id, String idCredit) {
        return echeanceDAO.getAllEcheanceByCredit(idCredit).stream()
                .filter(e -> e.getId().toString().equals(id))
                .findFirst();
    }

    public Predicate<Echeance> filterEcheance(String id) {
        return echeance -> echeance.getId().toString().equals(id);
    }
}