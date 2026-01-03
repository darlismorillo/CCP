package dao;

import turni.Turno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurniDao implements ITurniDao {

    @Override
    public void aggiungiTurno(Turno t) throws SQLException {
        String sql = "INSERT INTO TURNI_LAVORO (ID_TURNO, ID_DIPENDENTE, PIANO_ASSEGNATO, DATA_TURNO, ORA_INIZIO, ORA_FINE) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, t.getIdTurno());
            ps.setString(2, t.getIdDipendente());
            ps.setShort(3, t.getPianoAssegnato());
            ps.setDate(4, Date.valueOf(t.getDataTurno()));
            ps.setTime(5, Time.valueOf(t.getOraInizio()));
            ps.setTime(6, Time.valueOf(t.getOraFine()));
            ps.executeUpdate();
        }
    }

    @Override
    public List<Turno> getTurniPerDipendente(String idDipendente) throws SQLException {
        List<Turno> lista = new ArrayList<>();
        String sql = "SELECT * FROM TURNI_LAVORO WHERE ID_DIPENDENTE = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, idDipendente);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Turno(
                    rs.getInt("ID_TURNO"),
                    rs.getString("ID_DIPENDENTE"),
                    rs.getShort("PIANO_ASSEGNATO"),
                    rs.getDate("DATA_TURNO").toLocalDate(),
                    rs.getTime("ORA_INIZIO").toLocalTime(),
                    rs.getTime("ORA_FINE").toLocalTime()
                ));
            }
        }
        return lista;
    }

    @Override
    public void cancellaTurno(int idTurno) throws SQLException {
        String sql = "DELETE FROM TURNI_LAVORO WHERE ID_TURNO = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idTurno);
            ps.executeUpdate();
        }
    }
}
