package it.unipv.posw.careconnectpro.controller.utenti.infermiere;

import it.unipv.posw.careconnectpro.controller.utenti.infermiere.button.BtnBackHomeInfAL;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.ViewController;

public class GestioniPazientiController {
    private ViewController view;
    private IRSA model;
    private BtnBackHomeInfAL  indietroButton;


    public GestioniPazientiController(ViewController view, IRSA model) {
        this.view = view;
        this.model = model;

        indietroButton = new BtnBackHomeInfAL(view);
        view.getPazientePanel().getBackButton().addActionListener(indietroButton);


    }
}
