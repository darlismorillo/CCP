package src.it.unipv.posw.careconnectpro.model.persona.dipendente;

import it.unipv.posw.careconnectpro.model.persona.TipoUtente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

import java.time.LocalDate;

public class Medico extends Dipendente {

	public Medico(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String email,
			String cellulare, String password, LocalDate dataAssunzione) {
		super(codiceFiscale, nome, cognome, dataNascita, email, cellulare, password,
                TipoUtente.MEDICO, dataAssunzione);
	}

}