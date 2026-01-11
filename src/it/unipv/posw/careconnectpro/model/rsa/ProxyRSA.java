package it.unipv.posw.careconnectpro.model.rsa;


import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.TipoDipendente;

public class ProxyRSA implements IResidenzaSanitariaAssistenziale {

    private ResidenzaSanitariaAssistenziale rsa;
    private Dipendente utenteLoggato;

    public ProxyRSA(Dipendente amministratore) {
        this.utenteLoggato = amministratore;
        this.rsa = new ResidenzaSanitariaAssistenziale();
    }

    @Override
    public boolean registrazioneDipendente(Dipendente dipendente) {
        if(utenteLoggato != null  && utenteLoggato.getTipoDipendente() == TipoDipendente.AMMINISTRATORE) {
            return rsa.registrazioneDipendente(dipendente);
        }
        System.out.println("Solo gli amministratori possono registrare nuovi dipendenti");
        return false;
    }

    @Override
    public Dipendente loginDipendente(String cf, String password) {
        return rsa.loginDipendente(cf, password);
    }
}
