package it.unipv.posw.careconnectpro.model.rsa;

import it.unipv.posw.careconnectpro.jdbc.FacadeSingletonDB;
import it.unipv.posw.careconnectpro.model.parametri.diaro.Monitoraggio;
import it.unipv.posw.careconnectpro.model.parametri.ParametroVitale;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

public class RSAService {
	
    private final FacadeSingletonDB facadeDB;

    public RSAService() {
        facadeDB = FacadeSingletonDB.getIstanzaFacade();
    }

    public RSAService(FacadeSingletonDB facadeDB) {
        this.facadeDB = facadeDB;
    }
    
    public FacadeSingletonDB getFacadeDB() {
        return facadeDB;
    }
	
    
    public Dipendente login (String cf, String password) {
        Dipendente d = facadeDB.findDipendenteByCf(cf);
        if (d == null) return null;
        if (!d.getPassword().equals(password)) return null;
        return d;
    }

//    public void nuovoMonitoraggio (String idMonitoraggio, Paziente paziente, Dipendente dipendente, ParametroVitale pv, String note) {
//        Monitoraggio nMonitoraggio = new Monitoraggio(idMonitoraggio, paziente, dipendente, pv, note);
//
//        paziente.getDiarioClinico().addMonitoraggio(nMonitoraggio);
//        System.out.println("Aggiunto monitoraggio a " + paziente.getNome() + " " + paziente.getCognome() +
//                            "al Diario:" + paziente.getDiarioClinico().getIdDiario());
//    }

}
