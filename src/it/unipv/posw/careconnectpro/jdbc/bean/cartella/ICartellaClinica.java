package it.unipv.posw.careconnectpro.jdbc.bean.cartella;

import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;

public interface ICartellaClinica {

    boolean insertCartellaClinica(CartellaClinicaDB ccDB);
    boolean deleteCartellaClinicaByCf(String cf);
    int selectIdCartellaClinica(String cf);

}
