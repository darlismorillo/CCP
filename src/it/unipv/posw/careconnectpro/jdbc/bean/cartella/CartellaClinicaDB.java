package it.unipv.posw.careconnectpro.jdbc.bean.cartella;

import java.time.LocalDate;

public class CartellaClinicaDB {


    private String idPaziente;
    private int idCartella;
    private LocalDate dataCreazione;

    public CartellaClinicaDB(String idPazinete, LocalDate dataCreazione) {
        this.setIdCartella(idCartella);
        this.idPaziente = idPazinete;
        this.dataCreazione = dataCreazione;
    }

    public int getIdCartella() {
        return idCartella;
    }
    public void setIdCartella(int idCartella) {
        this.idCartella = idCartella;
    }
    public LocalDate getDataCreazione() {
        return dataCreazione;
    }
    public void setDataCreazione(LocalDate dataCreazione) {
        this.dataCreazione = dataCreazione;
    }
    public  String getIdPaziente() {
        return idPaziente;
    }
    public void setIdPaziente(String idPaziente) {
        this.idPaziente = this.idPaziente;
    }

}
