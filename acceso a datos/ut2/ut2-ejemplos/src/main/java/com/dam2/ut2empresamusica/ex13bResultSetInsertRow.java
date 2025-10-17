package com.dam2.ut2empresamusica;

import java.sql.*;

public class ex13bResultSetInsertRow {

         public static void main(String[] args) {
        try ( Connection connexio = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empresa","root","root");
        	Statement stmt = connexio.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
        	ResultSet rs = stmt.executeQuery("select * from clientes");	
        ) {
            
            System.out.println("Situem el cursor al final");
            System.out.println("Modifiquem l'adreça de l'últim registre");
            rs.last();
            rs.updateString("direccion", "C/ Pepe Ciges, 3");
            rs.updateRow();
            
            //Creem un nou registre en la taula de clients
            
            System.out.println("Creem un nou registre");
            rs.moveToInsertRow();
            rs.updateString(2,"Killy Lopez");
            rs.updateString(3,"Wall Street 3674");
            rs.insertRow();

            // Ens situem al principi del ResultSet
            System.out.println("Esborrem el primer registre");
            rs.absolute(1);
            rs.deleteRow();
 
        } catch(SQLException se) {
            //Errores de JDBC
            se.printStackTrace();
        }  
    }
    
}
