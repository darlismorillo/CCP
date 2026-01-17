package it.unipv.posw.careconnectpro.jdbc.bean.dipendente;

import java.util.List;

public interface IDipendenteDAO {

    boolean insertDipendente(DipendenteDB d);
    DipendenteDB selectDipendenteByCf(String cf);
    //List<DipendenteDB> selectAllDipendenti();
	DipendenteDB deleteDipendneteById(String cf, String pw);

}
