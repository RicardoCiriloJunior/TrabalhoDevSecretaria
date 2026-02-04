package org.example.util;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private final static Dotenv dotenv = Dotenv.configure().load();
    private final static String DB_PASSWORD = dotenv.get("DB_PASSWORD");
    private final static String DB_USER = dotenv.get("DB_USER");
    private final static String DB_URL = dotenv.get("DB_URL");

    public Connection connect() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            return conn;
        }
        catch (SQLException sqle) {
            throw new RuntimeException("Driver não encontrado");
        }

    }

    public void desconectar(Connection conn){
        try {
            if (conn != null && !conn.isClosed()){
                conn.close();
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }


}
