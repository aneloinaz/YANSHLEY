package Gestion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    private String url = "jdbc:mysql://localhost:3306/usurbiltex";
    private String user = "root";
    private String pass = "";
    private Connection conn = null;

    public Connection conectar() throws Exception {
        try {
            conn = DriverManager.getConnection(url, user, pass);
            return conn;
        }catch (Exception e) {
            System.err.println("Error al conectar la base de datos: " + e.getMessage());
        }
        return null;
    }
}
