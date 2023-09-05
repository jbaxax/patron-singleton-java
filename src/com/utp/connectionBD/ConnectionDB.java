package com.utp.connectionBD;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionDB {

    private static ConnectionDB instance = null;
    private static Connection con;
    private static final String URL = "jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=sqlutparquitectura";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String USER = "sa";
    private static final String PASS = "12345678";

    private ConnectionDB() {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Exito se logro conectar a la base de datos");

        } catch (Exception e) {
            System.out.println("Error al conectar:" + e.getMessage());
            e.printStackTrace();
        }
    }
    public synchronized static ConnectionDB getInstance(){
        if(instance ==null){
            instance = new ConnectionDB();
        }
        return instance;
    }
    public Connection getConnection(){
        return con;
    }
    public void close(){
        instance = null;
    }
}
