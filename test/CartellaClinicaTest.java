import it.unipv.posw.careconnectpro.model.persona.Paziente;
import org.junit.Before;
import  org.junit.Test;

import java.time.LocalDate;

public class CartellaClinicaTest {

    private Paziente paziente;
    @Before
    public void setUp() {
        // Dati identificativi
        String codiceFiscale = "BNCFRC85M10H501Z";
        String nome = "Francesco";
        String cognome = "Barbieri"; // Cognome comune e non legato a colori

        // Date
        LocalDate dataNascita = LocalDate.of(1985, 8, 10);
        LocalDate dataAssunzione = LocalDate.of(2023, 5, 15);

        // Recapiti e credenziali
        String email = "f.barbieri85@provider.it";
        String cellulare = "3479876543";
        String id = "PAZ-99";
        String password = "StrongPassword789!";

        // Creazione dell'oggetto Paziente
        paziente = new Paziente(
                codiceFiscale,
                nome,
                cognome,
                dataNascita,
                email,
                cellulare,
                id,
                password,
                dataAssunzione
        );
    }

    @Test
    public void creazioneCartella(){
        System.out.println("ID Cartella: " + paziente.getCartellaClinica().getIdCartellaClinica());
    }

}

