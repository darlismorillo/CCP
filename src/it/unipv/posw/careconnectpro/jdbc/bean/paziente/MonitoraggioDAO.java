package it.unipv.posw.careconnectpro.jdbc.bean.paziente;

import it.unipv.posw.careconnectpro.jdbc.ConnessioneDB;
import it.unipv.posw.careconnectpro.model.parametri.Monitoraggio;

import java.sql.*;

public class MonitoraggioDAO {
    private Connection conn;

    public boolean insertMonitoraggio(Monitoraggio m) {
        conn = ConnessioneDB.startConnection(conn,"ccp");
        PreparedStatement ps;
        boolean check = true;
        String sql =    "INSERTI INTO CCP.DIARIO_PARAMETRI" +
                        "(ID_DIARIO, DATA_INSERIMENTO  ID_DIPENDENTE, ID_PAZIENTE, TIPO_PARAMETRO, STATO, VALORE, NOTE)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,m.getPaziente().getDiarioClinico().getIdDiario());
            ps.setDate(2, Date.valueOf(m.getData_registrazione()));
            ps.setString(3, m.getDipendente().getIdDipendente());
            ps.setString(4, m.getPaziente().getCodiceFiscale());
            ps.setString(5, m.getStringParametroVitale());
            ps.setString(6, m.getParametroVitale().getStato());
            ps.setInt(7, m.getParametroVitale().getValore());
            ps.setString(8, m.getNote());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                return rs.getInt(1) == 1;
            }
            return check;

        } catch (SQLException e) {
            e.printStackTrace();
            check = false;
        }

        ConnessioneDB.closeConnection(conn);
        return check;

    }
}
