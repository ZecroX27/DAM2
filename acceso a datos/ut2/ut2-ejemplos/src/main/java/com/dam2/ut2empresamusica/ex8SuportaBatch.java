package com.dam2.ut2empresamusica;

import java.sql.*;

public class ex8SuportaBatch {

        public static void main(String[] args) {

        try ( Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empresa","root","root");
        	Statement stmt = conn.createStatement();)
        {           
            //COMPROVAR SUPORT BATCH
            DatabaseMetaData dm = conn.getMetaData();
            System.out.println("Suporta processament batch -> " + dm.supportsBatchUpdates());
            
        } catch(SQLException se) {
            //Errors de JDBC
            se.printStackTrace();
        }
    }
    
}
