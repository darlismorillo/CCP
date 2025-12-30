package dao;

import java.sql.*;

import persona.dipendente.*;

public class DipendenteDao implements IDipendenteDao {
//
    @Override
    public void addDipendente(Dipendente dipendente) throws SQLException{
        String sql =
                "INSERT INTO DIPENDENTI (CODICE_FISCALE, NOME, COGNOME, DATA_DI_NASCITA, EMAIL, NUMERO_TELEFONICO, ID_DIPENDENTE, DIPENDENTE_PASSWORD, RUOLO, DATA_INIZIO) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            ps.setString(10, "2025-12-30"); // Campo obbligatorio nello script SQL

            ps.executeUpdate();
            System.out.println("Dipendente inserito con successo!");
        }
    }


    public Dipendente login (String idDipendente, String password) throws SQLException{
        String sql = "SELECT * FROM DIPENDENTI WHERE ID_DIPENDENTE = ? AND DIPENDENTE_PASSWORD = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

             ps.setString(1, idDipendente);
             ps.setString(2, password);

             ResultSet rs = ps.executeQuery();

             if(rs.next()){
                 TipoDipendente tipo = TipoDipendente.valueOf(rs.getString("RUOLO").toUpperCase());

                 return switch (tipo) {
                     case MEDICO -> new Medico(
                             rs.getString("CODICE_FISCALE"), rs.getString("NOME"),
                             rs.getString("COGNOME"), rs.getDate("DATA_DI_NASCITA").toLocalDate(),
                             rs.getString("EMAIL"), rs.getString("NUMERO_TELEFONICO"),
                             rs.getString("ID_DIPENDENTE"), rs.getString("DIPENDENTE_PASSWORD"), tipo
                     );
                     case INFERMIERE -> new Infermiere(
                             rs.getString("CODICE_FISCALE"), rs.getString("NOME"),
                             rs.getString("COGNOME"), rs.getDate("DATA_DI_NASCITA").toLocalDate(),
                             rs.getString("EMAIL"), rs.getString("NUMERO_TELEFONICO"),
                             rs.getString("ID_DIPENDENTE"), rs.getString("DIPENDENTE_PASSWORD"), tipo
                     );
                     case AMMINISTRATORE -> new Amministratore(
                             rs.getString("CODICE_FISCALE"), rs.getString("NOME"),
                             rs.getString("COGNOME"), rs.getDate("DATA_DI_NASCITA").toLocalDate(),
                             rs.getString("EMAIL"), rs.getString("NUMERO_TELEFONICO"),
                             rs.getString("ID_DIPENDENTE"), rs.getString("DIPENDENTE_PASSWORD"), tipo
                     );
                 };
             }
        }
        return null;
    }

}
