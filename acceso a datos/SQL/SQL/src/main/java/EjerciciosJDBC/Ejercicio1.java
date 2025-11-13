package EjerciciosJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
1. Crear la clase ConexionBaseDatos con:

    	- atributos url, usuario y contraseña
    	- método estático getConexion que retorne un objeto Connection con la conexión establecida

 */
public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empresa2", "root", "root");
            System.out.println("Conexion exitosa " + conexion.getSchema());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
