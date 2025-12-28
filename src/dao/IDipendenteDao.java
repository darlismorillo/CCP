package dao;

import persona.dipendente.Dipendente;
import java.sql.SQLException;

public interface IDipendenteDao {
    void addDipendente(Dipendente dipendente) throws SQLException;

}
