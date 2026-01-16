package it.unipv.posw.careconnectpro.model.parametri;

import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Monitoraggio {

    private  Paziente paziente;
    private  String note;
    private final int id_monitoraggio;
    private  LocalDate data_registrazione;
    private  LocalDateTime ora_registrazione;
    private  ParametroVitale parametroVitale;
    private  Dipendente dipendente;

    public  Monitoraggio(int id_monitoraggio, Paziente paziente, Dipendente dipendente, ParametroVitale parametroVitale,
                        String note) {
        this.id_monitoraggio = id_monitoraggio;
        this.paziente = paziente;
        this.dipendente = dipendente;
        this.parametroVitale = parametroVitale;
        data_registrazione = LocalDate.now();
        ora_registrazione = LocalDateTime.now();
        this.note = note;

    }

    @Override
    public String toString() {
        return "Monitoraggio{" +
                "paziente=" + paziente +
                ", id_monitoraggio=" + id_monitoraggio +
                ", data_registrazione=" + data_registrazione +
                ", parametroVitale=" + parametroVitale +
                ", dipendente=" + dipendente +
                '}';
    }

    //Getter and Setter
    public ParametroVitale getParametroVitale() {
        return parametroVitale;
    }
    public String getStringParametroVitale() {
        return parametroVitale.toString();
    }
    public void setParametroVitale(ParametroVitale parametroVitale) {
        this.parametroVitale = parametroVitale;
    }
    public LocalDateTime getOra_registrazione() {
        return ora_registrazione;
    }
    public void setOra_registrazione(LocalDateTime ora_registrazione) {
        this.ora_registrazione = ora_registrazione;
    }
    public LocalDate getData_registrazione() {
        return data_registrazione;
    }
    public void setData_registrazione(LocalDate data_registrazione) {
        this.data_registrazione = data_registrazione;
    }
    public int getId_monitoraggio() {
        return id_monitoraggio;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public Paziente getPaziente() {
        return paziente;
    }
    public void setPaziente(Paziente paziente) {
        this.paziente = paziente;
    }
    public Dipendente getDipendente() {
        return dipendente;
    }
    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }
}
