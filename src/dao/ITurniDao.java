package dao;

import turni.Turno;
import java.sql.SQLException;
import java.util.List;

public interface ITurniDao {
    void aggiungiTurno(Turno turno) throws SQLException;
    List<Turno> getTurniPerDipendente(String idDipendente) throws SQLException;
    void cancellaTurno(int idTurno) throws SQLException;
}

