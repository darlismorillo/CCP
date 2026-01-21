package it.unipv.posw.careconnectpro.jdbc.bean.cartella;

import it.unipv.posw.careconnectpro.jdbc.ConnessioneDB;
import java.sql.*;


public class CartellaClinicaDAO implements ICartellaClinica {

    private Connection conn;

    @Override
    public boolean insertCartellaClinica(CartellaClinicaDB cartellaDB) {

        String sql = "INSERT INTO CARTELLA_CLINICA (ID_PAZIANTE, DATA_CREAZIONE) " +
                "VALUES (?,?)";
        try (Connection conn = ConnessioneDB.startConnection("cpp");
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            ps.setString(1, cartellaDB.getIdPaziente());
            ps.setString(2, String.valueOf(cartellaDB.getDataCreazione()));
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                String id_diario = "DP" + id;

                String nQuery = "UPDATE DIARO_PARAMETRI SET ID_CARTELLA_CLINICA = ? WHERE ID = ?";
                PreparedStatement ps2 = conn.prepareStatement(nQuery);

                ps2.setString(1, id_diario);
                ps2.setInt(2, id);
                ps2.executeUpdate();
                return true;
            } else {
                System.out.println("ID Diario Parametri non generato correttamente");

            }
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

//    public boolean insertCartellaClinica (CartellaClinicaDB ccDb)	{
//        String query =
//                "INSERT INTO CARTELLA_CLINICA (ID_PAZIENTE, DATA_CREAZIONE) VALUES (?,?)";
//        try (Connection conn = ConnessioneDB.startConnection("ccp");
//             PreparedStatement ps = conn.prepareStatement(query)) {
//
//            ps.setString(1, ccDb.getIdPaziente());
//            ps.setDate(2, Date.valueOf(ccDb.getDataCreazione()));
//            ps.executeUpdate();
//
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

    @Override
    public boolean deleteCartellaClinicaByCf(String cf) {
        String query = "DELETE FROM CARTELLA_CLINICA WHERE ID_PAZIENTE = ?";
        try (Connection conn = ConnessioneDB.startConnection("ccp");
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, cf);
            int deletedRows = ps.executeUpdate();
            return deletedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}