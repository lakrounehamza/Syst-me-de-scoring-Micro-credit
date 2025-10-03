package controller;

import DAO.ProfessionnelDAO;
import model.Professionnel;
import  java.util.*;
import java.util.function.*;
import  java.util.stream.Stream;
public class ProfessionnelController {
    public ProfessionnelDAO professionnelDAO;
    public ProfessionnelController(){
        professionnelDAO =new ProfessionnelDAO();
    }
    public void addProfessionnel(Professionnel professionnel){
        professionnelDAO.addProfessionnel(professionnel);
    }
    public ArrayList<Professionnel> getAllProfessionnel(){
        return professionnelDAO.getAllProfessionnel();
    }
    public Optional<Professionnel> getProfessionnelById(String id) {

        return professionnelDAO.getAllProfessionnel().stream()
                .filter(p -> p.getId().toString().equals(id))
                .findFirst();
    }

    public Predicate<Professionnel> filterProfess(String id) { return  profess -> profess.getId().toString().equals(id);} ;
}
