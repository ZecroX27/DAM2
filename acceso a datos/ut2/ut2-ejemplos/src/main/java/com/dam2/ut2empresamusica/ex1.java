package com.dam2.ut2empresamusica;// FER ÚS DE CLASSPATH (-cp) EN EXECUTAR, AMB LA RUTA AL JAR DE MYSQL

import java.sql.*;

public class ex1 {
    
    public static void main(String[] args) {

        Connection conn = null;

             // REGISTRAR EL DRIVER JA NO ÉS NECESSARI EN LES NOVES VERSIONS DEL JAR
            /* String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver).newInstance(); */

        //try ( Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa","root","root");) {
        try ( Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empresa","root","root");) {
        //try {

            // Establir la connexió amb la Base de Dades
            System.out.println("Connectant amb la base de dades...");

            System.out.println("Connexió establida amb la base de dades...");

        } catch(SQLException se) {
            se.printStackTrace();
        }
    }
    
}
