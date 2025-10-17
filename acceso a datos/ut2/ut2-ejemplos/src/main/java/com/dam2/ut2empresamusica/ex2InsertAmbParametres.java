package com.dam2.ut2empresamusica;/* Insert però amb pas de paràmetres. Faltaria afegir la comprovació inicial del pas dels paràmetres requerits */

import java.sql.*;

public class ex2InsertAmbParametres {
    
    public static void main(String[] args) {
        try ( Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/musica","root","root");
        	Statement stmt = conn.createStatement();
        ) {
            // 
            String sql = "INSERT INTO musics VALUES (" + Integer.parseInt(args[0]) + ",'" + args[1] + "','" + args[2] +"')";
            stmt.executeUpdate(sql);
            
            System.out.println("Registre afegit!");
            
        } catch(SQLException se) {
            //Errores de JDBC
            se.printStackTrace();
        }
    }  
}
