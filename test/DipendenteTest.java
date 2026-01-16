import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.TipoDipendente;
import org.junit.Test;

import java.time.LocalDate;

public class DipendenteTest {
    @Test
    public void testPassword() {
        new Dipendente("CodiceFi", "nome", "cognome", LocalDate.now(), "nomecognome@",
                "12345678", "MED001", "passwordtest", TipoDipendente.MEDICO, LocalDate.now());
    }

}
