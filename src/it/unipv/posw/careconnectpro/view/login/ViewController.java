package it.unipv.posw.careconnectpro.view.login;

import it.unipv.posw.careconnectpro.view.dipendenti.AmmPanel;

import javax.swing.*;
import java.awt.*;

public class ViewController extends JFrame {
    private JFrame frame;
    private JPanel panel;
    private LoginPanel loginPanel;
    private AmmPanel ammPanel;

    public  ViewController() {
        frame = new JFrame();
        panel = new JPanel();


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setTitle("CareConnectPro");
        frame.getContentPane().add(panel);

        loginPanel = new LoginPanel();
        panel.add(loginPanel);

        ammPanel = new AmmPanel();
        panel.add(ammPanel);
        ammPanel.setVisible(false);

        frame.setVisible(true);

    }

    public LoginPanel getLoginPanel() {
        return loginPanel;
    }
    public AmmPanel getAmmPanel() { return ammPanel; }


}
