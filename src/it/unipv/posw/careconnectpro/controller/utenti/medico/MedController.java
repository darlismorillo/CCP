package it.unipv.posw.careconnectpro.controller.utenti.medico;


import it.unipv.posw.careconnectpro.controller.utenti.medico.button.BtnMonitoraggioActionListener;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.ViewController;

import java.util.List;

public class MedController {
    private IRSA model;
    private ViewController view;
    private BtnMonitoraggioActionListener monitoraggioBtn;
    private MonitoraggioController monitoraggioController;
    private TerapiaController terapiaController;



    public MedController(IRSA model, ViewController view) {
        this.model = model;
        this.view = view;

        monitoraggioBtn = new BtnMonitoraggioActionListener(view);
        view.getMedPanel().getOpenButton().addActionListener(monitoraggioBtn);
        monitoraggioController = new MonitoraggioController(model, view);
        terapiaController = new TerapiaController (model, view);

    }

    public TerapiaController getTerapiaController() {
        return terapiaController;
    }
    public void setTerapiaController(TerapiaController terapiaController) {
        this.terapiaController = terapiaController;
    }
    public MonitoraggioController getMonitoraggioController() {
        return monitoraggioController;
    }
    public void setMonitoraggioController(MonitoraggioController monitoraggioController) {
        this.monitoraggioController = monitoraggioController;
    }
    public BtnMonitoraggioActionListener getMonitoraggioBtn() {
        return monitoraggioBtn;
    }
    public void setMonitoraggioBtn(BtnMonitoraggioActionListener monitoraggioBtn) {
        this.monitoraggioBtn = monitoraggioBtn;
    }
    public ViewController getView() {
        return view;
    }
    public void setView(ViewController view) {
        this.view = view;
    }
    public IRSA getModel() {
        return model;
    }
    public void setModel(IRSA model) {
        this.model = model;
    }
}
