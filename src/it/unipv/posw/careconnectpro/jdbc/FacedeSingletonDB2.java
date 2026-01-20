package it.unipv.posw.careconnectpro.jdbc;

import it.unipv.posw.careconnectpro.jdbc.bean.dipendente.DipendenteDB;
import it.unipv.posw.careconnectpro.jdbc.bean.dipendente.PersonaDAO;
import it.unipv.posw.careconnectpro.model.persona.Persona;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.FactoryDipendente;

public class FacedeSingletonDB2 {

    private static FacedeSingletonDB2 istanza;
    private PersonaDAO personaDAO;

    public FacedeSingletonDB2() {
        personaDAO = new PersonaDAO();
    }

    public static FacedeSingletonDB2 getIstanza() {
        if (istanza == null) {
            istanza = new FacedeSingletonDB2();
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


    //Getter and Setter
    public PersonaDAO getPersonaDAO() {
        return personaDAO;
    }
    public void setPersonaDAO(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

}
