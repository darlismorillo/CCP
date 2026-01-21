package it.unipv.posw.careconnectpro.model.persona;

import it.unipv.posw.careconnectpro.model.parametri.cartella.CartellaClinica;

import java.time.LocalDate;

public class Paziente extends Persona {

    private CartellaClinica cartellaClinica;
    public Paziente(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String email,
                    String cellulare, String id, String password, LocalDate dataAssunzione) {
        super(codiceFiscale, nome, cognome, dataNascita, email, cellulare, null, TipoUtente.PAZIENTE, dataAssunzione);

        cartellaClinica = new CartellaClinica();

    }

    public CartellaClinica getCartellaClinica() {
        return cartellaClinica;
    }

    public void setCartellaClinica(CartellaClinica cartellaClinica) {
        this.cartellaClinica = cartellaClinica;
    }
}