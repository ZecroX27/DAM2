package com.dam2.ut2pedidos;
import java.sql.*;

public class ej1Conexion {

    public static void main(String[] args) {
        // TODO code application logic here

        try ( Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pedidos","root","root");)
        {
            //REGISTRANDO EL DRIVER
            //String driver = "org.postgresql.Driver";
            //Class.forName(driver).newInstance();
                            
            //Abrir la conexión con la Base de Datos
            System.out.println("Conectando con la Base de datos...");

            System.out.println("Conexión establecida con la Base de datos..." + conexion.getSchema());

        } catch(SQLException se) {
            //Errores de JDBC
            se.printStackTrace();
        }
        }//end try
}
