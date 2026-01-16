
import it.unipv.posw.careconnectpro.model.parametri.Monitoraggio;
import it.unipv.posw.careconnectpro.model.parametri.ParametroVitale;
import it.unipv.posw.careconnectpro.model.parametri.TipiParametroVitale;
import it.unipv.posw.careconnectpro.model.parametri.diaro.DiarioClinico;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Infermiere;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;

import java.time.LocalDate;

public class MainTestMonitoraggio {

    public static void main(String[] args) {
        System.out.println("--- Inizio Test Sistema Monitoraggio ---");

        // 1. Creazione del Diario Clinico (con ID univoco come da DB)
        DiarioClinico diario = new DiarioClinico(101); //

        // 2. Creazione di un Paziente associato al Diario
        Paziente paziente = new Paziente(
                "RSSMRA80A01F205X", "Mario", "Rossi",
                LocalDate.of(1980, 1, 1), "mario@email.it",
                "3331234567", diario); //

        // 3. Creazione di un Dipendente (Infermiere) che esegue la rilevazione
        Dipendente infermiere = new Infermiere(
                "BNCGNN90M15F205Z", "Gianni", "Bianchi",
                LocalDate.of(1990, 5, 15), "gianni@rsa.it",
                "3339876543", "INF001", "password123",
                LocalDate.now()); //

        // 4. Creazione di un Parametro Vitale (es. Temperatura)
        ParametroVitale temperatura = new ParametroVitale(
                TipiParametroVitale.TEMPERATURA, 38, "Febbre Alta"); //

        // 5. Creazione del Monitoraggio (il "fatto" clinico)
        // Usiamo il costruttore che hai aggiornato
        Monitoraggio nuovaRilevazione = new Monitoraggio(
                1, paziente, infermiere, temperatura, "Il paziente lamenta brividi"); //

        // 6. Aggiunta AUTOMATICA al diario del paziente
        paziente.getDiarioClinico().addMonitoraggio(nuovaRilevazione); //

        // --- VERIFICA DEI RISULTATI ---
        System.out.println("Paziente: " + paziente.getNome() + " " + paziente.getCognome());
        System.out.println("ID Diario: " + paziente.getDiarioClinico().getIdDiario());
        System.out.println("Rilevazioni presenti nel diario: " + paziente.getDiarioClinico().getMonitoraggi().size());

        if (!paziente.getDiarioClinico().getMonitoraggi().isEmpty()) {
            Monitoraggio m = paziente.getDiarioClinico().getMonitoraggi().get(0);
            System.out.println("\n--- Dettaglio Ultimo Monitoraggio ---");
            System.out.println("Data: " + m.getData_registrazione() + " Ore: " + m.getOra_registrazione());
            System.out.println("Parametro: " + m.getParametroVitale().getParametroVitale());
            System.out.println("Valore: " + m.getParametroVitale().getValore());
            System.out.println("Stato: " + m.getParametroVitale().getStato());
            System.out.println("Eseguito da: " + m.getDipendente().getNome() + " (ID: " + m.getDipendente().getIdDipendente() + ")");
            System.out.println("Note: " + m.getNote());
        }
    }
}