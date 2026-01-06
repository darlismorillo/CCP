package it.unipv.posw.careconnectpro.model.rsa;

import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

public interface IResidenzaSanitariaAssistenziale {

	boolean registrazioneDipendente(Dipendente d);
	Dipendente loginDipendente (String cf, String pw);

}
