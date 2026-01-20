import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.persona.TipoUtente;
import org.junit.Test;

import java.time.LocalDate;

public class DipendenteTest {
    @Test
    public void testPassword() {
        new Dipendente("CodiceFi", "nome", "cognome", LocalDate.now(), "nomecognome@",
                "12345678", "passwordtest", TipoUtente.MEDICO, LocalDate.now());
    }
}
