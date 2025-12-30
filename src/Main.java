import persona.dipendente.*;
import dao.*;
import java.time.LocalDate;
import java.sql.SQLException;
//

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver trovato e caricato con successo!");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver non trovato! Controlla il Classpath.");
            e.printStackTrace();
        }

        // Inizializzazione corretta
        IDipendenteDao dipendenteDao = new DipendenteDao();

        // Medico per il test
        Medico nuovoMedico = new Medico(
                "RSSMRA80A01H501G", "Maria", "Ross",
                LocalDate.of(1980, 1, 1), "maria.ross@ospedale.it",
                "3331234567", "MED007", "Pass123", // Attenzione: SQL accetta max 8 caratteri per pass
                TipoDipendente.MEDICO
        );

        System.out.println("--- TEST INSERIMENTO ---");
        try {
            dipendenteDao.addDipendente(nuovoMedico);
        } catch (SQLException e) {
            System.err.println("Errore inserimento: " + e.getMessage());
        }

        System.out.println("\n--- TEST LOGIN ---");
        try {
            // Testiamo con un utente già presente nel tuo script SQL (es. MED001)
            Dipendente utenteLoggato = dipendenteDao.login("MED001", "DocPass1");
            if (utenteLoggato != null) {
                System.out.println("Login OK: Benvenuto " + utenteLoggato.getNome());
            } else {
                System.out.println("Login fallito!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}