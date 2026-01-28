package it.unipv.posw.careconnectpro.controller.utenti.infermiere;

import it.unipv.posw.careconnectpro.controller.utenti.infermiere.button.BtnAddMonitoraggioAL;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.ViewController;
import it.unipv.posw.careconnectpro.view.dipendenti.infermiere.InfPanel;

public class InfController {

    private IRSA model;
    private ViewController view;
    private BtnAddMonitoraggioAL addMonitoraggio;
    private GestioniPazientiController gestioneController;


    public InfController(IRSA model, ViewController view) {
        this.model = model;
        this.view = view;

        addMonitoraggio = new BtnAddMonitoraggioAL(view);
        gestioneController = new GestioniPazientiController(view, model);

        view.getInfPanel().getMonitoraggioButton().addActionListener(addMonitoraggio);


    }



}
