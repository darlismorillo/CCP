package it.unipv.posw.careconnectpro.jdbc.bean;

import it.unipv.posw.careconnectpro.jdbc.ConnessioneDB;
import it.unipv.posw.careconnectpro.model.parametri.Monitoraggio;
import it.unipv.posw.careconnectpro.model.parametri.ParametroVitale;
import it.unipv.posw.careconnectpro.model.persona.Paziente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class DiarioParametriDAO {
    private Connection conn;

    public DiarioParametriDAO() {
    }

    public boolean insertParamentri(Paziente paziente, Monitoraggio monitoraggio) throws SQLException {
        conn = ConnessioneDB.startConnection(conn,"cpp");
        PreparedStatement ps;
        boolean check = true;

        String sql =    "INSERT INTO DIARIO_PARAMETRI (ID_RILEVAZIONE, ID_DIPENDENTE ,ID_PAZIANTE, TIPO_PARAMETRO, STAT0, VALORE) " +
                        "VALUES (?,?,?,?,?,?)";
        try
        {
            ps = conn.prepareStatement(sql);

            ps.setInt(1,monitoraggio.getId_monitoraggio());
            ps.setString(2,monitoraggio.getDipendente().getIdDipendente());
            ps.setString(3, paziente.getCodiceFiscale());
            ps.setString(4, monitoraggio.getStringParametroVitale());
            ps.setString(5,monitoraggio.getParametroVitale().getStato());
            ps.setInt(6,monitoraggio.getParametroVitale().getValore());

            ps.executeUpdate();
            return check;
        }
        catch(SQLException e){
            e.printStackTrace();
            check = false;
        }

        ConnessioneDB.closeConnection(conn);
        return check;
    }

    //Aggiungere una select per i monitoraggi effettuati a un solo paziente
}
