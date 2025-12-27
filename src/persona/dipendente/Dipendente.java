package persona.dipendente;

import java.time.LocalDate;
import persona.Persona;

public abstract class Dipendente extends Persona {

    private String idDipendente;
    private String password;
    private TipoDipendente tipoDipendente;
//	private LocalDate dataAssunzione;

    public Dipendente(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String email,
                      String cellulare, String idDipendente, String password, TipoDipendente tipoDipendente) {
        super(codiceFiscale, nome, cognome, dataNascita, email, cellulare);
        this.idDipendente = idDipendente;
        this.password = password;
        this.tipoDipendente = tipoDipendente;
    }

    public String getIdDipendente() {
        return idDipendente;
    }

    public void setIdDipendente(String idDipendente) {
        this.idDipendente = idDipendente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoDipendente getTipoDipendente() {
        return tipoDipendente;
    }

    public void setTipoDipendente(TipoDipendente tipoDipendente) {
        this.tipoDipendente = tipoDipendente;
    }



}
