package com.dam2.ut2empresamusica;// FER ÚS DE CLASSPATH (-cp) EN EXECUTAR, AMB LA RUTA AL JAR DE MYSQL


import java.sql.*;

public class ex2Insert {
    
    public static void main(String[] args) {

            /* REGISTRAR EL DRIVER JA NO ÉS NECESSARI EN LES NOVES VERSIONS DEL JAR
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver).newInstance();*/

	/*  String jdbcUrl = "jdbc:mysql://localhost:3306/empresa";
            Connection connexio = DriverManager.getConnection(jdbcUrl,"root","");*/

            // Establir la connexió amb la Base de Dades
            System.out.println("Connectant amb la base de dades...");

        try ( Connection connexio = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empresa","root","root");
        	Statement stmt = connexio.createStatement();	
        ) {

            System.out.println("Connexió establida amb la base de dades...");

            String sql = "CREATE TABLE venedors (" +
                    "id int NOT NULL," +
                    "nom varchar(50) NOT NULL default ''," +
                    "data_ingres date NOT NULL default '2000-01-01'," +
                    "salari float NOT NULL default '0'," +
                    "PRIMARY KEY  (id))";
          
            stmt.executeUpdate(sql);

            // Afegim dades a la taula venedors
            sql = "INSERT INTO venedors VALUES (1,'pepe', '2007-01-01', 12000)";
            stmt.executeUpdate(sql);
            
            System.out.println("Registre afegit!");

        } catch(SQLException se) {
            se.printStackTrace();
        }
    }
    
}
