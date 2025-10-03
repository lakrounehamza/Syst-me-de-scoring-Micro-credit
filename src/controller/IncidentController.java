package controller;

import DAO.IncidentDAO;
import model.Incident;
import java.util.*;
import java.util.function.*;

public class IncidentController {
    public IncidentDAO incidentDAO;

    public IncidentController(){
        incidentDAO = new IncidentDAO();
    }

    public void addIncident(Incident incident, String idEcheance){
        incidentDAO.addIncident(incident, idEcheance);
    }

    public void updateIncident(Incident incident){
        incidentDAO.updateIncident(incident);
    }

    public void deleteIncident(String id){
        incidentDAO.deleteIncident(id);
    }

    public Predicate<Incident> filterIncident(String id) {
        return incident -> incident.getId().toString().equals(id);
    }
}