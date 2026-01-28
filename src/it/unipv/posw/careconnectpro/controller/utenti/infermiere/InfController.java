package it.unipv.posw.careconnectpro.controller.utenti.infermiere;

import it.unipv.posw.careconnectpro.controller.utenti.infermiere.button.BtnAddMonitoraggioAL;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.ViewController;
import it.unipv.posw.careconnectpro.view.dipendenti.infermiere.InfPanel;

public class InfController {

    private IRSA model;
    private ViewController view;
    private BtnAddMonitoraggioAL addMonitoraggio;


    public InfController(IRSA model, ViewController view) {
        this.model = model;
        this.view = view;

        addMonitoraggio = new BtnAddMonitoraggioAL(view);

        view.getInfPanel().getMonitoraggioButton().addActionListener(addMonitoraggio);


    }



}
