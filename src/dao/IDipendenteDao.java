package dao;

import persona.dipendente.Dipendente;
import java.sql.SQLException;

public interface IDipendenteDao {
    void addDipendente(Dipendente dipendente) throws SQLException;
    Dipendente login (String idDipendente, String password) throws SQLException;
}
