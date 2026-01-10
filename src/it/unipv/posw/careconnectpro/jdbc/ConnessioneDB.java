package it.unipv.posw.careconnectpro.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnessioneDB {
    private static ConnessioneDB instance;
    private Connection connection;
    private String username;
    private String password;
    private String dbDriver;
    private String dbURL;

	private ConnessioneDB() {
        Properties prop = new Properties();

        try{
         prop.load(new FileInputStream("properties/properties"));
         this.username = prop.getProperty("DBUSER");
         this.password = prop.getProperty("DBPW");
         this.dbDriver = prop.getProperty("DBDRIVER");
         this.dbURL = prop.getProperty("DBURL");
         Class.forName(dbDriver);
        } catch(Exception e){
            e.printStackTrace();
        }
    }


    public static synchronized ConnessioneDB getInstance() {
        if (instance == null) {
            instance = new ConnessioneDB();
        }
        return instance;
    }


    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            // Utilizza lo schema di default o parametrizzato come in ConnessioneDB
            connection = DriverManager.getConnection(dbURL, username, password);
            connection.setAutoCommit(true);
        }
        return connection;
    }
}