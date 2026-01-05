package it.unipv.posw.careconnectpro.jdbc;

import it.unipv.posw.careconnectpro.jdbc.bean.dipendente.DipendenteDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.dipendente.DipendenteDB;
import it.unipv.posw.careconnectpro.jdbc.bean.dipendente.IDipendenteDAO;
import it.unipv.posw.careconnectpro.model.persona.Dipendente;
import it.unipv.posw.careconnectpro.model.persona.TipoDipendente;

public class FacadeSingletonDB {

	private static FacadeSingletonDB istanzaDB;

	private IDipendenteDAO dipendenteDAO;
	

    private FacadeSingletonDB() {
        dipendenteDAO = new DipendenteDAO();
    }

    public static FacadeSingletonDB getIstanzaFacade() {
		if(istanzaDB == null) {
			istanzaDB = new FacadeSingletonDB();
		}
		return istanzaDB;
	}
    
    public Dipendente loginDipendente(String cf, String password) {
        DipendenteDB db = dipendenteDAO.selectDipendenteByCfAndPw(cf, password);
        if (db == null) return null;
        return new Dipendente(
            db.getCodiceFiscale(),
            db.getNome(),
            db.getCognome(),
            db.getDataNascita(),
            db.getEmail(),
            db.getNumeroTelefonico(),
            db.getIdDipendente(),
            db.getPassword(),
            TipoDipendente.valueOf(db.getRuolo()),
            db.getDataInizio()
        );
    }

    public boolean insertDipendente(Dipendente d) {
        DipendenteDB db = new DipendenteDB(
                d.getCodiceFiscale(),
                d.getNome(),
                d.getCognome(),
                d.getDataNascita(),
                d.getEmail(),
                d.getCellulare(),
                d.getIdDipendente(),
                d.getPassword(),
                d.getTipoDipendente().name(),
                d.getDataAssunzione());
        return dipendenteDAO.insertDipendente(db);
    }

}
