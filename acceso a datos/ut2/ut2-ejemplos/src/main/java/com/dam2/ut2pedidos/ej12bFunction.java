package com.dam2.ut2pedidos;
import java.sql.*;

public class ej12bFunction {

     public static void main(String[] args) {
        // TODO code application logic here
        Connection conn = null;
        PreparedStatement stmt = null;  // puede ser PreparedStatement o CallableStatement
        ResultSet resultado = null;

        try {
            
            //Abrir la conexión con la Base de Datos
            System.out.println("Conectando con la Base de datos...");
            String jdbcUrl = "jdbc:postgresql://localhost:5432/pedidos";
            conn = DriverManager.getConnection(jdbcUrl,"root","root");
            System.out.println("Conexión establecida con la Base de datos...");
            
            //String sentenciaSql = "call public.cuentaproductos()";
            String sentenciaSql = "select public.cuentaproductos()";

                // hecho con PreparedStatement
              //stmt = conn.prepareCall(sentenciaSql);
              stmt = conn.prepareStatement(sentenciaSql);
              resultado = stmt.executeQuery();
              //resultado = stmt.execute();
              resultado.next();
 
              if (resultado.wasNull())
                System.out.println("No hay productos");
              else {
                int cont = resultado.getInt(1);
                System.out.println("El total de productos es " + cont);
              }
            }catch(SQLException se) {
            //Errores de JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Errores de Class.forName
            e.printStackTrace();
        } finally {
            try {
                if(stmt!=null)
                    stmt.close();
                if(conn!=null)
                    conn.close();
                System.out.println("Cerrando conexión con la BD");
            } catch(SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try  
    }
    
}
