package it.unipv.posw.careconnectpro.model.parametri;

import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Monitoraggio {

    private Paziente paziente;
    private String note;
    private final int id_monitoraggio;
    private LocalDate data_registrazione;
    private LocalDateTime ora_registrazione;
    private ParametroVitale parametroVitale;
    private Dipendente dipendente;

    public  Monitoraggio(int id_monitoraggio, Dipendente dipendente) {
        this.id_monitoraggio = id_monitoraggio;
        data_registrazione = LocalDate.now();
        ora_registrazione = LocalDateTime.now();
        this.dipendente = dipendente;

    }

    public void addMonitoraggio(Paziente paziente, ParametroVitale parametroVitale, String note) {
       this.paziente = paziente;
       this.note = note;
       this.parametroVitale = parametroVitale;
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
