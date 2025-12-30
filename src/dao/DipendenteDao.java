package dao;

import java.sql.Connection;
import persona.dipendente.Dipendente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class DipendenteDao implements IDipendenteDao {

    @Override
    public void addDipendente(Dipendente dipendente) throws SQLException{
        String sql =
                "INSERT INTO dipendenti (codice_fiscale, nome, cognome, data_nascita, email, cellulare, id_dipendente, password, tipo) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, dipendente.getCodiceFiscale());
            ps.setString(2, dipendente.getNome());
            ps.setString(3, dipendente.getCognome());
            ps.setDate  (4, Date.valueOf(dipendente.getDataNascita()));
            ps.setString(5, dipendente.getEmail());
            ps.setString(6, dipendente.getCellulare());
            ps.setString(7, dipendente.getIdDipendente());
            ps.setString(8, dipendente.getPassword());
            ps.setString(9, dipendente.getTipoDipendente().name());

            ps.executeUpdate();
            System.out.println("Dipendente inserito con successo!");
        }
    }
}
