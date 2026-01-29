package src.it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.terapia;

import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.terapia.TerapiaDB;

public interface ITerapiaDAO {

	int insertTerapia(TerapiaDB tDb);
	boolean deleteTerapiaById(int id);

}
