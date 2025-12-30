import persona.dipendente.*;
import dao.*;
import java.time.LocalDate;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver trovato e caricato con successo!");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver non trovato! Controlla il Classpath.");
            e.printStackTrace();
        }
        IDipendenteDao dipendenteDao = new DipendenteDao();

        Medico nuovoMedico = new Medico(
                "RSSMRA80A01H501U",
                "Mario",
                "Rossi",
                LocalDate.of(1980, 1, 1),
                "mario.rossi@ospedale.it",
                "3331234567",
                "MED001",
                "password Sicura123",
                TipoDipendente.MEDICO
        );

        System.out.println("--- TEST INSERIMENTO ---");
        try {
            // Proviamo a inserire il medico nel database
            dipendenteDao.inserisciDipendente(nuovoMedico);
            System.out.println("Medico inserito correttamente!");
        } catch (SQLException e) {
            System.err.println("Errore durante l'inserimento: " + e.getMessage());
            // Se l'errore è "Duplicate entry", significa che il test era già stato fatto
        }

        System.out.println("\n--- TEST LOGIN ---");
        String idPerLogin = "MED007";
        String passPerLogin = "passwordSicura123";

        try {
            // Cerchiamo di recuperare il dipendente con le credenziali
            Dipendente utenteLoggato = dipendenteDao.login(idPerLogin, passPerLogin);

            if (utenteLoggato != null) {
                System.out.println("Login effettuato con successo!");
                System.out.println("Benvenuto Dott. " + utenteLoggato.getNome() + " " + utenteLoggato.getCognome());
                System.out.println("Ruolo: " + utenteLoggato.getTipoDipendente());

                // Verifica polimorfismo
                if (utenteLoggato instanceof Medico) {
                    System.out.println("Il sistema riconosce correttamente che sei un Medico.");
                }
            } else {
                System.out.println("Login fallito: ID o Password errati.");
            }
        } catch (SQLException e) {
            System.err.println("Errore tecnico durante il login: " + e.getMessage());
        }
    }
}