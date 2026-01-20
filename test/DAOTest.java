import it.unipv.posw.careconnectpro.jdbc.bean.dipendente.DipendenteDAO;
import it.unipv.posw.careconnectpro.jdbc.bean.dipendente.DipendenteDB;
import org.junit.Test;

import java.time.LocalDate;

public class DAOTest {

    private DipendenteDB db;

    
    @Test
    public void testaDipendente() {
        DipendenteDB db = new DipendenteDB("RSSMRA80A01F205Z", "Mario", "Rossi",
                LocalDate.of(1980, 1, 1), "admin@test.it", "333111", "pass123", "AMMINISTRATORE", LocalDate.now());

        DipendenteDAO dao = new DipendenteDAO();
        boolean risultalto = dao.insertDipendente(db);
        System.out.println("Dipendente inserito nel DB? " + risultalto);
    }
}
