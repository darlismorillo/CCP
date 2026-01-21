package it.unipv.posw.careconnectpro.jdbc.bean.cartella;

public interface ICartellaClinica {

    boolean insertCartellaClinica(CartellaClinicaDB ccDb);
    boolean deleteCartellaClinicaByCf(String cf);

}
