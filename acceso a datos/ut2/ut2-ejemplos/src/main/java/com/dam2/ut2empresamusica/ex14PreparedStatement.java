package com.dam2.ut2empresamusica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ex14PreparedStatement {

     public static void main(String[] args) {
        try ( Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empresa","root","root");
        	PreparedStatement pstmt = conn.prepareStatement("update facturas set serie=? where id=?");  
        ) {
            
            /* Creem l'objecte PreparedStatement
            pstmt = conn.prepareStatement("update facturas set serie=? where id=?");            */
            
            // Afegim els paràmetres del PreparedStatement
            pstmt.setString(1, "B");
            pstmt.setLong(2, 1);
            
            // Executem el Prepared Statement
            pstmt.executeUpdate();
            System.out.println("Modificada la factura!");
            
        } catch(SQLException se) {
            //Errores de JDBC
            se.printStackTrace();
        }
    }
    
}
