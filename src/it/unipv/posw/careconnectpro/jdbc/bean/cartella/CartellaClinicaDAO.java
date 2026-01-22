package it.unipv.posw.careconnectpro.jdbc.bean.cartella;

import it.unipv.posw.careconnectpro.jdbc.ConnessioneDB;
import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;

import java.sql.*;


public class CartellaClinicaDAO implements ICartellaClinica {

    private Connection conn;


    @Override
    public boolean insertCartellaClinica(CartellaClinicaDB ccDb)	{
        String query =
                "INSERT INTO CARTELLA_CLINICA (ID_PAZIENTE, DATA_CREAZIONE) VALUES (?,?)";
        try (Connection conn = ConnessioneDB.startConnection("ccp");
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, ccDb.getIdPaziente());
            ps.setDate(2, Date.valueOf(ccDb.getDataCreazione()));
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

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

    public int selectIdCartellaClinica(String cf) {
        String sql = "SELECT ID_CARTELLA_CLINICA FROM CARTELLA_CLINICA WHERE ID_PAZIENTE = ?";
        int id = 0;
        try(Connection conn = ConnessioneDB.startConnection("ccp");
            PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setString(1, cf);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("ID_CARTELLA_CLINICA");
            }

        } catch (Exception e) {
        e.printStackTrace();
        return -1;}

        return id;
    }
}