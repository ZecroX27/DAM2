package com.dam2.ut2empresamusica;

import java.sql.*;

public class ex13ResultSetInsertRow {
    
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
		if (cod ==6)
		{
			/* PER A INSERIR UNA NOVA FILA HEM DE FER:
				1. MOVETOINSERTROW() QUE CREA L'ESPAI PER A LA NOVA ENTRADA
				2. ACTUALITZAR AMB UPDATE CADA COLUMNA
				3. INSERIR LA NOVA FILA AMB INSERTROW()
				4. TORNAR A LA POSICIÓ DE PARTIDA AMB MOVETOCURRENTROW() */
			rs.moveToInsertRow();
			rs.updateInt("id",5);
			rs.updateString("titol","Street Legal");
			rs.updateInt("preu",16);
			rs.updateInt("music",1);
			rs.insertRow();
			rs.moveToCurrentRow();
		}
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
