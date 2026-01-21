package it.unipv.posw.careconnectpro.jdbc.bean.cartella;

import it.unipv.posw.careconnectpro.jdbc.ConnessioneDB;
import it.unipv.posw.careconnectpro.model.parametri.cartella.Monitoraggio;
import it.unipv.posw.careconnectpro.model.persona.Paziente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MonitoraggioDAO {

    public boolean insert(Monitoraggio monitoraggio) throws SQLException {

        boolean result = true;

        String sql = "INSERT INTO MONITORAGGI ( ID_CARTELLA_CLINICA, ID_INFERMIERE," +
                "TIPO_PARAMETRO, VALORE, DATA_MONITORAGGIO, STATO,  ALERT, NOTE " +
                "VALUES (?,?,?,?,?,?,?,?)";

        try (Connection conn = ConnessioneDB.startConnection("cpp")) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, monitoraggio.getPaziente().getCartellaClinica().getIdCartellaClinica());
            ps.setString(2, monitoraggio.getDipendente().getCodiceFiscale());
            ps.setString(3, String.valueOf(monitoraggio.getParametroVitale()));
            ps.setInt(4, monitoraggio.getParametroVitale().getValore());
            ps.setDate(5, Date.valueOf(monitoraggio.getDataRegistrazione()));
            ps.setString(6, monitoraggio.getParametroVitale().getStato());
            ps.setString(7, monitoraggio.getNote());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }

    public List<MonitoraggioDB> selectMonitorggiByCfPaziente(Paziente paziente) {
        List<MonitoraggioDB> monitoraggi = new ArrayList<>();
        String sql = "SELECT * FROM MONITORAGGI WHERE CODICE_FISCALE = ?";

        try(Connection conn = ConnessioneDB.startConnection("cpp");
            PreparedStatement ps = conn.prepareStatement(sql);){

            ps.setString(1, paziente.getCodiceFiscale());
            try(ResultSet rs = ps.executeQuery();){
                while (rs.next()) {
                    MonitoraggioDB m = new MonitoraggioDB(
                            rs.getString("ID_RILEVAZIONE"),
                            rs.getString("ID_DIARIO"),
                            rs.getString("ID_DIPENDENTE"),
                            rs.getString("ID_PAZIENTE"),
                            rs.getString("TIPO_PARAMETRO"),
                            rs.getDate("DATA_MONITORAGGIO").toLocalDate(),
                            rs.getString("STATO"),
                            rs.getString("VALORE"),
                            rs.getString("NOTE")
                    );
                    monitoraggi.add(m);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return monitoraggi;
    }
}
