package com.dam2.ut2empresamusica;

import java.sql.*;

public class ex12ResultDelete {
    
    public static void main(String[] args) {
            try ( Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/musica","root","root");
        	Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
        	ResultSet rs = stmt.executeQuery("select * from discos");	
        ) {

            int cod,nMusic; String titol; double preu; 
            while (rs.next())
            {
            	cod = rs.getInt(1);
		if (cod ==2)
			rs.deleteRow();
            	titol = rs.getString(2);
            	preu = rs.getDouble("preu");
            	nMusic = rs.getInt("music");
            	System.out.println("Id: " + cod + ",\t" + titol + ", preu: " + preu + " euros, del music " + nMusic);
            }            
        } catch(SQLException se) {
            //Errors de JDBC
            se.printStackTrace();
        }
    }
    
}
