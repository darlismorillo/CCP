package it.unipv.posw.careconnectpro.controller;

import it.unipv.posw.careconnectpro.controller.login.LoginController;
import it.unipv.posw.careconnectpro.model.rsa.RSAService;
import it.unipv.posw.careconnectpro.view.login.ViewController;

public class FacadeController {

    private LoginController loginController;
    private RSAService model;
    private ViewController view;

    public FacadeController(RSAService model, ViewController view) {
        loginController = new LoginController(model, view);
    }


}
