package it.unipv.posw.careconnectpro.model.persona.dipendente;

import java.time.LocalDate;

public interface IDipendente {
	String getIdDipendente();
    String getPassword();
    void setPassword(String password) ;
    TipoDipendente getTipoDipendente();
    LocalDate getDataAssunzione();
}
