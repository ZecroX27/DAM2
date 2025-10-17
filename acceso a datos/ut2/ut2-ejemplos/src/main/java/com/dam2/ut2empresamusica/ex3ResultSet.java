package com.dam2.ut2empresamusica;// FER ÚS DE CLASSPATH (-cp) EN EXECUTAR, AMB LA RUTA AL JAR DE MYSQL


import java.sql.*;

public class ex3ResultSet {
    
    public static void main(String[] args) {

        try ( Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empresa","root","root");
        	Statement stmt = conexion.createStatement();
        	ResultSet rs = stmt.executeQuery("select * from grupos");	
        ) {
            /* REGISTRAR EL DRIVER JA NO ÉS NECESSARI EN LES NOVES VERSIONS DEL JAR
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver).newInstance();*/
        
            // Establir la connexió amb la Base de Dades
            System.out.println("Connexió establida amb la base de dades...");

/*            System.out.println("Timeout de consulta: "+stmt.getQueryTimeout()+ " sg");
            System.out.println("Nombre màxim de registres a buscar: "+stmt.getMaxRows());
            System.out.println("Mida màxima de camp: "+stmt.getMaxFieldSize()+" bytes");
            System.out.println("Nombre de registres retornats cada vegada: "+stmt.getFetchSize());*/
            int id ; String descr;
            while(rs.next() )
            { 
            	id = rs.getInt(1);	// llig la primera columna (1) de la fila actual, que és int (getInt)
            	// id = rs.getInt("id");	, equivalent a la línia anterior
            	//descr = rs.getString(2);
            	descr = rs.getString("descripcion");	// equivalent a la línia anterior
            	System.out.println("Identificador: " + id + ", descripció: " + descr);
            }

        } catch(SQLException se) {
            se.printStackTrace();
        }
    }
    
}
