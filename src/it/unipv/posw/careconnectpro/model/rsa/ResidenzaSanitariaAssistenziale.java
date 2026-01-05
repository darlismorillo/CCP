package it.unipv.posw.careconnectpro.model.rsa;

import it.unipv.posw.careconnectpro.jdbc.FacadeSingletonDB;
import it.unipv.posw.careconnectpro.model.persona.Dipendente;

public class ResidenzaSanitariaAssistenziale implements IResidenzaSanitariaAssistenziale {

    private FacadeSingletonDB facadeDB;

    public ResidenzaSanitariaAssistenziale() {
        facadeDB = FacadeSingletonDB.getIstanzaFacade();
    }

    @Override
    public boolean registrazioneDipendente(Dipendente d) {
        return facadeDB.insertDipendente(d);
    }
    
    @Override
    public Dipendente loginDipendente(String cf, String password) {
        return facadeDB.loginDipendente(cf, password);
    }
}
