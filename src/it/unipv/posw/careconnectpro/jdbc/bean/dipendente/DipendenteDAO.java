package it.unipv.posw.careconnectpro.jdbc.bean.dipendente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import it.unipv.posw.careconnectpro.jdbc.ConnessioneDB;

public class DipendenteDAO implements IDipendenteDAO {

	private Connection conn;
	
	public DipendenteDAO()	{
	}
	
	@Override
	public boolean insertDipendente(DipendenteDB d) {
		conn = ConnessioneDB.startConnection(conn, "ccp");
		PreparedStatement ps1;
		boolean check = true;

	    String query = "INSERT INTO ccp.DIPENDENTI " +
                "(CODICE_FISCALE, NOME, COGNOME, DATA_DI_NASCITA, EMAIL, NUMERO_TELEFONICO, ID_DIPENDENTE, PASSWORD, RUOLO, DATA_INIZIO) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?)";

		try {
			ps1 = conn.prepareStatement(query);

	        ps1.setString(1, d.getCodiceFiscale());
	        ps1.setString(2, d.getNome());
	        ps1.setString(3, d.getCognome());
	        ps1.setDate(4, Date.valueOf(d.getDataNascita()));
	        ps1.setString(5, d.getEmail());
	        ps1.setString(6, d.getNumeroTelefonico());
	        ps1.setString(7, d.getIdDipendente());
	        ps1.setString(8, d.getPassword());
	        ps1.setString(9, d.getRuolo());
	        ps1.setDate(10, Date.valueOf(d.getDataInizio()));

	        ps1.executeUpdate();
	        return true;
		}
		catch(Exception e){
			e.printStackTrace();
			check = false;
		}

		ConnessioneDB.closeConnection(conn);
		return check;
	}
	
	public List<DipendenteDB> selectAllDipendenti() {
		conn = ConnessioneDB.startConnection(conn, "ccp");
		List<DipendenteDB> lista = new ArrayList<>();
        PreparedStatement ps1;
        ResultSet rs1;

		String query = "SELECT * FROM ccp.DIPENDENTI";

		try {
            ps1 = conn.prepareStatement(query);
            rs1 = ps1.executeQuery();

            while(rs1.next()) {
            	DipendenteDB d = new DipendenteDB(
            			rs1.getString("CODICE_FISCALE"),
            			rs1.getString("NOME"),
            			rs1.getString("COGNOME"),
            			rs1.getDate("DATA_DI_NASCITA").toLocalDate(),
            			rs1.getString("EMAIL"),
            			rs1.getString("NUMERO_TELEFONICO"),
            			rs1.getString("ID_DIPENDENTE"),
            			rs1.getString("DIPENDENTE_PASSWORD"),
            			rs1.getString("RUOLO"),
            			rs1.getDate("DATA_INIZIO").toLocalDate()
            			);
            	lista.add(d);
            }
		} catch(Exception e) {
			e.printStackTrace();
		}

		ConnessioneDB.closeConnection(conn);
		return lista;
	}
	
	@Override
    public DipendenteDB selectDipendenteByCf (String cf) {
		DipendenteDB d = null;
        conn = ConnessioneDB.startConnection(conn, "ccp");
        PreparedStatement ps1;
        ResultSet rs1;
        
        String query = "SELECT * FROM ccp.DIPENDENTI WHERE cf = ?";
        
        try {
            ps1 = conn.prepareStatement(query);
            ps1.setString(1, cf);
            rs1 = ps1.executeQuery();

            while (rs1.next()) {
                d = new DipendenteDB(
                        rs1.getString("CODICE_FISCALE"),
                        rs1.getString("NOME"),
                        rs1.getString("COGNOME"),
                        rs1.getDate("DATA_DI_NASCITA").toLocalDate(),
                        rs1.getString("EMAIL"),
                        rs1.getString("NUMERO_TELEFONICO"),
                        rs1.getString("ID_DIPENDENTE"),
                        rs1.getString("DIPENDENTE_PASSWORD"),
                        rs1.getString("RUOLO"),
                        rs1.getDate("DATA_INIZIO").toLocalDate()

                );
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
        
		ConnessioneDB.closeConnection(conn);
		return d;
    }
	
	@Override
    public DipendenteDB selectDipendenteByCfAndPw (String cf, String pw) {
		DipendenteDB d = null;
        conn = ConnessioneDB.startConnection(conn, "ccp");
        PreparedStatement ps1;
        ResultSet rs1;
        
        String query = "SELECT * FROM ccp.DIPENDENTI WHERE cf = ? AND password = ?";
        
        try {
            ps1 = conn.prepareStatement(query);
            ps1.setString(1, cf);
            ps1.setString(2, pw);
            rs1 = ps1.executeQuery();
           
            while (rs1.next()) {
                d = new DipendenteDB(
                        rs1.getString("CODICE_FISCALE"),
                        rs1.getString("NOME"),
                        rs1.getString("COGNOME"),
                        rs1.getDate("DATA_DI_NASCITA").toLocalDate(),
                        rs1.getString("EMAIL"),
                        rs1.getString("NUMERO_TELEFONICO"),
                        rs1.getString("ID_DIPENDENTE"),
                        rs1.getString("DIPENDENTE_PASSWORD"),
                        rs1.getString("RUOLO"),
                        rs1.getDate("DATA_INIZIO").toLocalDate()
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
        
		ConnessioneDB.closeConnection(conn);
		return d;
    }
}
