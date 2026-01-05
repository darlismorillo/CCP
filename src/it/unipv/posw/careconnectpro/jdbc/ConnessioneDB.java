package it.unipv.posw.careconnectpro.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnessioneDB {
	
	private static final String PROPERTYDBDRIVER = "DBDRIVER";
	private static final String PROPERTYDBURL = "DBURL";
	private static final String PROPERTYNAME = "DBUSER"; 
	private static final String PROPERTYPSW = "DBPSW"; 
	
	private static String username;
	private static String password;
	private static String dbDriver;
	private static String dbURL;
	
	private static void init() {
		Properties p = new Properties(System.getProperties());
			try {
				p.load(new FileInputStream("properties/properties"));
				username = p.getProperty(PROPERTYNAME);
				password = p.getProperty(PROPERTYPSW);
				dbDriver = p.getProperty(PROPERTYDBDRIVER);
				dbURL = p.getProperty(PROPERTYDBURL);
			
			}catch(Exception e) {
				e.printStackTrace();
		}
	}
	
	public static boolean isOpen(Connection conn)	{
		try {
			if (conn != null && !conn.isClosed()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}
	
	public static Connection closeConnection(Connection conn)		{
		if ( !isOpen(conn) )
			return null;
		try	{
			conn.close();
			conn = null;
		} 
		catch (SQLException e)	{
			e.printStackTrace();
			return null;
		}
		return conn;
	}
	
	public static Connection startConnection(Connection conn, String schema) {
		init();
		System.out.println(dbURL);
		
		if ( isOpen(conn) )
			closeConnection(conn);

		try	{
			dbURL=String.format(dbURL,schema); 
			System.out.println(dbURL);
			Class.forName(dbDriver);
			
			conn = DriverManager.getConnection(dbURL, username, password);	// Apertura connessione
			conn.setAutoCommit(true);
		}
		catch (Exception e)	{
			e.printStackTrace();
			return null;
		}
		
		return conn;
	}

}
