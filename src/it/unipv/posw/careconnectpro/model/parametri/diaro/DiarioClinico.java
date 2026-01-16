package it.unipv.posw.careconnectpro.model.parametri.diaro;

import it.unipv.posw.careconnectpro.model.parametri.Monitoraggio;

import java.util.ArrayList;
import java.util.List;

public class DiarioClinico {
    private  int idDiario;
    private List<Monitoraggio> monitoraggi;

    public DiarioClinico(int idDiario) {
        this.idDiario = idDiario;
        this.monitoraggi = new ArrayList<>();
    }

    public List<Monitoraggio> getMonitoraggi() {
        return monitoraggi;
    }
    public void setMonitoraggi(List<Monitoraggio> monitoraggi) {
        this.monitoraggi = monitoraggi;
    }
    public int getIdDiario() {
        return idDiario;
    }
    public void setIdDiario(int idDiario) { this.idDiario = idDiario;}

    public void addMonitoraggio(Monitoraggio monitoraggio) {
        this.monitoraggi.add(monitoraggio);
    }



}
