import dao.DipendenteDao;
import dao.IDipendenteDao;
import persona.dipendente.Dipendente;

import java.sql.SQLException;

public class Accesso {
    private static Dipendente dipendenteLoggato;
    private final IDipendenteDao dipendenteDao = new DipendenteDao();

    public boolean loginVerifica (String idDipendente, String password) {
        try {
            dipendenteLoggato = dipendenteDao.login(idDipendente, password);
            if (dipendenteLoggato != null){
                System.out.println("Benvenuto " + dipendenteLoggato.getNome() + " " + dipendenteLoggato.getCognome());
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Credenziali sbagliate, in caso di necessita contattare l'amministrazione");
        return false;
    }

    public static Dipendente getDipendenteLoggato() {
        return dipendenteLoggato;
    }
    public static void setDipendenteLoggato(Dipendente dipendenteLoggato) {
        Accesso.dipendenteLoggato = dipendenteLoggato;
    }

    public void logout (){
        dipendenteLoggato = null;
    }
}
