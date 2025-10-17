package com.dam2.ut2empresamusica;

import java.sql.*;

public class ex5ForwardOnly {

         public static void main(String[] args) {

        try ( Connection connexio = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empresa","root","root");
        	Statement stmt = connexio.createStatement();
        	ResultSet rs = stmt.executeQuery("select * from articulos");	
        ) {
            
            System.out.println("Cursor abans de la primera fila? = "+ rs.isBeforeFirst());
            int id;
            String nom;
            java.math.BigDecimal preu;
            String codi;
            int grup;
            
            while (rs.next()) {
                //Obtenim la informació per el nom de la columna
                id = rs.getInt("id");
                nom = rs.getString("nombre");
                preu = rs.getBigDecimal("precio");
                
                //Obtenim la informació per l'index de la columna
                codi = rs.getString(4);
                grup = rs.getInt(5);
                
                //Mostrem la informació
                System.out.print("Número de Fila=" + rs.getRow());
                System.out.print(", id: " + id);
                System.out.print(", nom: " + nom);
                System.out.print(", preu: " + preu.floatValue()+" euros");
                System.out.print(", codi: " + codi);
                System.out.println(", grup: " + grup);
            }
            System.out.println("Cursor després de l'última fila? = " +rs.isAfterLast());    
            rs.first();        
        } catch(SQLException se) {
            //Errores de JDBC
            se.printStackTrace();
        }
    }
    
}
