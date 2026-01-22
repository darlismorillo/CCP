package it.unipv.posw.careconnectpro.jdbc;

import it.unipv.posw.careconnectpro.jdbc.bean.cartella.CartellaClinicaDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.cartella.CartellaClinicaDB;
import it.unipv.posw.careconnectpro.jdbc.bean.cartella.ICartellaClinica;
import it.unipv.posw.careconnectpro.jdbc.bean.cartella.terapia.ITerapiaDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.cartella.terapia.TerapiaDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.persona.IPersonaDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.persona.PersonaDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.persona.PersonaDB;
import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.persona.Persona;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.FactoryDipendente;

public class FacadeSingletonDB {

    private static FacadeSingletonDB istanza;
    private IPersonaDAO personaDAO;
    private ICartellaClinica cartellaClinicaDAO;
    private ITerapiaDAO terapiaDAO;

    public FacadeSingletonDB() {
        personaDAO = new PersonaDAO();
        cartellaClinicaDAO = new CartellaClinicaDAO();
        terapiaDAO = new TerapiaDAO();
    }

    public static FacadeSingletonDB getIstanza() {
        if (istanza == null) {
            istanza = new FacadeSingletonDB();
        }
        return istanza;
    }

    public boolean insertPersona(Persona p) {
        PersonaDB personaDB;
        personaDB = new PersonaDB(
                p.getCodiceFiscale(),
                p.getNome(),
                p.getCognome(),
                p.getDataNascita(),
                p.getEmail(),
                p.getCellulare(),
                p.getPassword(),
                p.getTipoUtente().name(),
                p.getDataInizio());

        return personaDAO.insertPersona(personaDB);
    }

    public Dipendente findDipendenteByCf(String cf) {
        PersonaDB db = personaDAO.selectPersonaByCf(cf);
        if (db == null) return null;
        Dipendente dipendente = FactoryDipendente.getDipendente(
                db.getRuolo(),
                db.getCodiceFiscale(),
                db.getNome(),
                db.getCognome(),
                db.getDataNascita(),
                db.getEmail(),
                db.getNumeroTelefonico(),
                db.getPassword(),
                db.getDataInizio()
        );
        return dipendente;
    }

    public boolean deletePersona(String cf) {
        return personaDAO.deletePersonaByCf(cf);
    }

    public boolean insertCartellaClinica(CartellaClinica cc) {
        CartellaClinicaDB cartellaClinicaDB;
        int id;
        cartellaClinicaDB = new CartellaClinicaDB(
                cc.getIdPaziente(),
                cc.getDataCreazione());

        cartellaClinicaDAO.insertCartellaClinica(cartellaClinicaDB);
        id = cartellaClinicaDAO.selectIdCartellaClinica(cc.getIdPaziente());
        if (id != -1) {
            cc.setIdCartellaClinica(id);
        } else {
            System.out.println("Id non configurato correttamente");
            return false;
        }


        return true;
    }

    public boolean deleteCartellaClinica(String cf)	{
        return cartellaClinicaDAO.deleteCartellaClinicaByCf(cf);
    }


    //Getter and Setter
    public IPersonaDAO getPersonaDAO() {
        return personaDAO;
    }
    public void setPersonaDAO(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

}
