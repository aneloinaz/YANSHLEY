package Gestion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    private String url = "jdbc:mysql://localhost:3306/usurbiltex"; //url de concexión
    private String user = "root"; //usuario de la base de datos
    private String pass = ""; //contraseña
    private Connection conn = null;

    public Connection conectar() throws Exception {
        try {
            conn = DriverManager.getConnection(url, user, pass); // se hace la conexión
            return conn; // retorna la conexión para usarla en otras funciones
        }catch (Exception e) {
            System.err.println("Error al conectar la base de datos: " + e.getMessage());
        }
        return null;
    }
}
