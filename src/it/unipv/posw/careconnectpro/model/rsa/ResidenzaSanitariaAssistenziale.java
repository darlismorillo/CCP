package it.unipv.posw.careconnectpro.model.rsa;

import it.unipv.posw.careconnectpro.jdbc.FacadeSingletonDB;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

public class ResidenzaSanitariaAssistenziale implements IResidenzaSanitariaAssistenziale {

    private final FacadeSingletonDB facadeDB;

    public ResidenzaSanitariaAssistenziale() {
        facadeDB = FacadeSingletonDB.getIstanzaFacade();
    }

    @Override
    public boolean registrazioneDipendente(Dipendente d) {
        return facadeDB.insertDipendente(d);
    }

    public boolean rimuoviDipendente(String idDipendente) {
        return facadeDB.deleteDipendente(idDipendente);
        //return false;
    }
    }

