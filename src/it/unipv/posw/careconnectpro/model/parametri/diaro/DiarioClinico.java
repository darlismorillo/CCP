package it.unipv.posw.careconnectpro.model.parametri.diaro;

import it.unipv.posw.careconnectpro.model.parametri.ParametroVitale;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Infermiere;

import java.time.LocalDate;

public class DiarioClinico {
    private ParametroVitale parametroVitale;
    private LocalDate dataDiario;
    private Infermiere infermiere;
    private Dipendente dipendente;

    public DiarioClinico(Infermiere infermiere, Dipendente dipendente, ParametroVitale parametroVitale, LocalDate dataDiario) {
        this.dataDiario = dataDiario;
        this.infermiere = infermiere;
        this.parametroVitale = parametroVitale;
    }
}
