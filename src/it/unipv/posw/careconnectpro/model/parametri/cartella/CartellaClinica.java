package it.unipv.posw.careconnectpro.model.parametri.cartella;

import java.util.ArrayList;
import java.util.List;

public class CartellaClinica {
    private String idCartellaClinica;
    private List<Monitoraggio> monitoraggi;

    public CartellaClinica() {
        this.idCartellaClinica = idCartellaClinica;
        this.monitoraggi = new ArrayList<>();
    }

    public void addMonitoraggi(Monitoraggio m){
        this.monitoraggi.add(m);
    }
    public List<Monitoraggio> getMonitoraggi() {
        return monitoraggi;
    }
    public void setMonitoraggi(List<Monitoraggio> monitoraggi) {
        this.monitoraggi = monitoraggi;
    }
    public String getIdCartellaClinica() {
        return idCartellaClinica;
    }
    public void setIdCartellaClinica(String idCartellaClinica) { this.idCartellaClinica = idCartellaClinica;}
    public void addMonitoraggio(Monitoraggio monitoraggio) {
        this.monitoraggi.add(monitoraggio);
    }



}
