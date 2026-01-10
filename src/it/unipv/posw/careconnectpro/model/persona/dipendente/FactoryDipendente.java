package it.unipv.posw.careconnectpro.model.persona.dipendente;

import java.time.LocalDate;

public class FactoryDipendente {

    public static Dipendente creaDipendente(String tipoStringa, String cf, String nome, String cognome,
                                            LocalDate nascita, String email, String cell,
                                            String id, String pw, LocalDate assunzione) {

        TipoDipendente tipo = TipoDipendente.valueOf(tipoStringa.toUpperCase());
        return switch (tipo) {
            case MEDICO -> new Medico(cf, nome, cognome, nascita, email, cell, id, pw, assunzione);
            case INFERMIERE -> new Infermiere(cf, nome, cognome, nascita, email, cell, id, pw, assunzione);
            case AMMINISTRATORE -> new Amministratore(cf, nome, cognome, nascita, email, cell, id, pw, assunzione);
        };
    }
}
