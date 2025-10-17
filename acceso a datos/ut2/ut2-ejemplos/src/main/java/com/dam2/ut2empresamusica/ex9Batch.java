package com.dam2.ut2empresamusica;

import java.sql.*;

public class ex9Batch {

        public static void main(String[] args) {

        try ( Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empresa","root","root");)
        {
        	try(Statement stmt = conn.createStatement();)
        	{
		    conn.setAutoCommit(false);
		    
		    // Afegim sentències SQL en mode Batch
		    String sql = "insert into articulos values(8,'HD 120G',100.0,'HD120',2)";
		    stmt.addBatch(sql);
		    sql = "insert into articulos values(9,'HD 160G',120.0,'HD160',2)";
		    stmt.addBatch(sql);
		    sql = "insert into articulos values(10,'HD 200G',140.0,'HD200',2)";
		    stmt.addBatch(sql);
		    int result[] = stmt.executeBatch();
		    conn.commit();

		    for (int i=0; i < result.length;i++) {
		        System.out.println("Sentència [" + i + "]: resultat: "+ result[i] + " OK");
		    }
            		conn.setAutoCommit(true);
        	} 
        	catch(SQLException se) {
			conn.rollback();
			conn.setAutoCommit(true);
        	}
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());		
        }
    }
    
}
