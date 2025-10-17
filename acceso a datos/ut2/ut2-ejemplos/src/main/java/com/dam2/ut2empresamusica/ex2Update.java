package com.dam2.ut2empresamusica;

import java.sql.*;

public class ex2Update {
    
    public static void main(String[] args) {
        try ( Connection connexio = DriverManager.getConnection("jdbc:postgresql://172.27.0.3:5432/muscia","root","root");
        	Statement stmt = connexio.createStatement();
        ) {

            // Actualitzem un preu
            String sql = "UPDATE discos SET preu = 10 WHERE ID = 1";
            int retorn = stmt.executeUpdate(sql);
            System.out.println("El valor retornat per executeUpdate és " + retorn);
            System.out.println("Registre canviat!");           
        } catch(SQLException se) {
            System.out.println("S'ha llançat una excepció");    
            se.printStackTrace();
        }
    }
}
