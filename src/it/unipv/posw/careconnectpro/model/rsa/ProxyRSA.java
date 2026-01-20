package it.unipv.posw.careconnectpro.model.rsa;


import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.persona.TipoUtente;

public class ProxyRSA implements IResidenzaSanitariaAssistenziale {

    private final ResidenzaSanitariaAssistenziale rsa;
    private final Dipendente utenteLoggato;

    public ProxyRSA(Dipendente amministratore) {
        this.utenteLoggato = amministratore;
        this.rsa = new ResidenzaSanitariaAssistenziale();
    }

    @Override
    public boolean registrazioneDipendente(Dipendente dipendente) {
        if(utenteLoggato != null  && utenteLoggato.getTipoDipendente() == TipoUtente.AMMINISTRATORE) {
            return rsa.registrazioneDipendente(dipendente);
        }
        System.out.println("Solo gli amministratori possono registrare nuovi dipendenti");
        return false;
    }

    @Override
    public boolean rimuoviDipendente(String idDipendente)	{
        if(utenteLoggato != null  && utenteLoggato.getTipoDipendente() == TipoUtente.AMMINISTRATORE) {
            return rsa.rimuoviDipendente(idDipendente);
        }
        throw new RuntimeException("Solo gli amministratori possono rimuovere i dipendenti");
    }
}
