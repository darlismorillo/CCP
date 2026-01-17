package it.unipv.posw.careconnectpro.model.persona;

import it.unipv.posw.careconnectpro.model.parametri.diaro.DiarioClinico;

import java.time.LocalDate;

public class Paziente extends Persona {

    //	private PianoTerapeutico pianoPersonale;
    private final DiarioClinico diarioClinico;

    public Paziente(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String email,
                    String cellulare, DiarioClinico diarioClinico ) {
        super(codiceFiscale, nome, cognome, dataNascita, email, cellulare);
        this.diarioClinico = diarioClinico;
    }

    public DiarioClinico getDiarioClinico() {
        return diarioClinico;
    }

}