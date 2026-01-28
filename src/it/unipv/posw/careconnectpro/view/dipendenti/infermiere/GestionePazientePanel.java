package it.unipv.posw.careconnectpro.view.dipendenti.infermiere;

import javax.swing.*;
import java.awt.*;

public class GestionePazientePanel extends JPanel {

    private JTable pazienteTable;
    private JButton inserisciButton, backButton;

    public GestionePazientePanel() {
        Font mediumFont = new Font("Arial", 0, 16);
        Font largeFont = new Font("Arial", 0, 20);
        setVisible(true);
        setLayout(new BorderLayout());

        pazienteTable = new JTable();
        pazienteTable.setFont(mediumFont);
        //pazienteTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPane = new JScrollPane(pazienteTable);


        JPanel panel = new JPanel();
        inserisciButton = new JButton("Inserisci Monitoraggio");
        inserisciButton.setFont(largeFont);
        backButton = new JButton("Indietro");
        backButton.setFont(largeFont);

        panel.add(inserisciButton);
        panel.add(backButton);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

    }

    public JButton getInserisciButton() {
        return inserisciButton;
    }
    public JButton getBackButton() {
        return backButton;
    }

}
