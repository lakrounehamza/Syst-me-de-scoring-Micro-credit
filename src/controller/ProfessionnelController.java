package controller;

import DAO.ProfessionnelDAO;
import model.Professionnel;

public class ProfessionnelController {
    public ProfessionnelDAO professionnelDAO;
    public ProfessionnelController(){
        professionnelDAO =new ProfessionnelDAO();
    }
    public void addProfessionnel(Professionnel professionnel){
        professionnelDAO.addProfessionnel(professionnel);
    }
}
