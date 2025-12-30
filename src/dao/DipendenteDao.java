package dao;

import java.sql.*;

import persona.dipendente.*;

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

    public void inserisciDipendente(Dipendente d) {
        System.out.println("DEBUG: Inizio metodo inserimento...");
        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("DEBUG: Connessione stabilita!");
            String sql = "...";
            PreparedStatement ps = conn.prepareStatement(sql);
            // ... set dei parametri ...
            System.out.println("DEBUG: Eseguo la query...");
            ps.executeUpdate();
            System.out.println("DEBUG: Query eseguita con successo!");
        } catch (SQLException e) {
            System.out.println("DEBUG: ERRORE TROVATO!");
            e.printStackTrace();
        }
    }

    public Dipendente login (String idDipendente, String password) throws SQLException{
        String sql = "SELECT * FROM dipendenti WHERE id_dipendente = ? AND password = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

             ps.setString(1, idDipendente);
             ps.setString(2, password);

             ResultSet rs = ps.executeQuery();

             if(rs.next()){
                 TipoDipendente tipo = TipoDipendente.valueOf(rs.getString("tipo_dipendente"));

                 switch (tipo){
                     case MEDICO:
                         return new Medico(
                                 rs.getString("codice_fiscale"), rs.getString("nome"),
                                 rs.getString("cognome"), rs.getDate("data_nascita").toLocalDate(),
                                 rs.getString("email"), rs.getString("cellulare"),
                                 rs.getString("id_dipendente"), rs.getString("password"), tipo
                         );

                     case INFERMIERE:
                         return new Infermiere(
                                 rs.getString("codice_fiscale"), rs.getString("nome"),
                                 rs.getString("cognome"), rs.getDate("data_nascita").toLocalDate(),
                                 rs.getString("email"), rs.getString("cellulare"),
                                 rs.getString("id_dipendente"), rs.getString("password"), tipo
                         );

                     case AMMINISTRATORE:
                         return new Amministratore(
                                 rs.getString("codice_fiscale"), rs.getString("nome"),
                                 rs.getString("cognome"), rs.getDate("data_nascita").toLocalDate(),
                                 rs.getString("email"), rs.getString("cellulare"),
                                 rs.getString("id_dipendente"), rs.getString("password"), tipo
                         );
                 }
             }
        }
        return null;
    }

}
