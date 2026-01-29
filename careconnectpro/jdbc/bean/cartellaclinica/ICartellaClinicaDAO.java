package src.it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica;

import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.CartellaClinicaDB;

public interface ICartellaClinicaDAO {

	int insertCartellaClinica(it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.CartellaClinicaDB ccDb);
	CartellaClinicaDB selectCartellaClinicaByCf(String cf);

}
