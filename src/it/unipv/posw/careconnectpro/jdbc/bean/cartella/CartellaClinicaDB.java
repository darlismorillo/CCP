package it.unipv.posw.careconnectpro.jdbc.bean.cartella;

import java.time.LocalDate;

public class CartellaClinicaDB {


    private String idPaziente;
    private LocalDate dataCreazione;

    public CartellaClinicaDB( String idPazinete, LocalDate dataCreazione) {
        this.idPaziente = idPazinete;
        this.dataCreazione = dataCreazione;
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
