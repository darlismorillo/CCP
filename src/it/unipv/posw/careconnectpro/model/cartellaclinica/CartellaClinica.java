package it.unipv.posw.careconnectpro.model.cartellaclinica;

import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.persona.Paziente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CartellaClinica {
    private int idCartellaClinica;
            private String idPaziente;
    private List<Monitoraggio> monitoraggi;
    private LocalDate dataCreazione;

    public CartellaClinica(Paziente p) {
        this.setIdCartellaClinica(idCartellaClinica);
        this.idPaziente = p.getCodiceFiscale();
        this.monitoraggi = new ArrayList<>();
        this.setDataCreazione(p.getDataInizio());
    }

    public void addMonitoraggio(Monitoraggio monitoraggio) {
        this.monitoraggi.add(monitoraggio);
    }
    public List<Monitoraggio> getMonitoraggi() {
        return monitoraggi;
    }
    public void setMonitoraggi(List<Monitoraggio> monitoraggi) {
        this.monitoraggi = monitoraggi;
    }
    public int getIdCartellaClinica() {
        return idCartellaClinica;
    }
    public void setIdCartellaClinica(int idCartellaClinica) { this.idCartellaClinica = idCartellaClinica;}
    public LocalDate getDataCreazione() {
        return dataCreazione;
    }
    public void setDataCreazione(LocalDate dataCreazione) {
        this.dataCreazione = dataCreazione;
    }
    public String getIdPaziente() {
        return idPaziente;
    }

}
