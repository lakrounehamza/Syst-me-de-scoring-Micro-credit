package controller;

import DAO.CreditDAO;
import model.Credit;
import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class CreditController {
    public CreditDAO creditDAO;

    public CreditController(){
        creditDAO = new CreditDAO();
    }

    public void addCredit(Credit credit, String idPersonne){
        creditDAO.addCredit(credit, idPersonne);
    }

    public void updateCredit(Credit credit){
        creditDAO.upDateCredit(credit);
    }

    public void deleteCredit(String id){
        creditDAO.deleteCredit(id);
    }

    public ArrayList<Credit> getAllCreditByIDPersonne(String idPersonne){
        return creditDAO.getAllCreditByIDPersonne(idPersonne);
    }

    public Optional<Credit> getCreditById(String id, String idPersonne) {
        return creditDAO.getAllCreditByIDPersonne(idPersonne).stream()
                .filter(c -> c.getId().toString().equals(id))
                .findFirst();
    }

    public Predicate<Credit> filterCredit(String id) {
        return credit -> credit.getId().toString().equals(id);
    }
}