package it.unipv.posw.careconnectpro.model.persona;

import java.time.LocalDate;

public interface IDipendente {
	String getIdDipendente();
    String getPassword();
    TipoDipendente getTipoDipendente();
    LocalDate getDataAssunzione();
}
