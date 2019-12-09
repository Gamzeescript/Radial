package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    Connection conn = null;

    static String db = "radio";
    static String user = "root";
    static String pass = "root";
    static String url = "jdbc:mysql://localhost/" + db + "?useSSL=false";

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            if (conn != null) {
                System.out.println("Conexion establecida con exito");
            }
        } catch (Exception e) {
            System.out.println("Conexion Rechazada");
        }
    }

    public Connection conectar() {
        return conn;
    }

    public void desconectar() throws SQLException {
        conn.close();
    }

    public static void main(String args[]) {
        Conexion c = new Conexion();
        c.conectar();

    }

}
