package com.dam2.ut2empresamusica;/* Exemple de SELECT utilitzant RESULTSET
 */
import java.sql.*;

public class ex4Select {
    
    public static void main(String[] args) {

        try ( Connection connexio = DriverManager.getConnection("jdbc:postgresql://localhost:5432/musica","root","root");
        	Statement stmt = connexio.createStatement();
        	ResultSet rs = stmt.executeQuery("select * from discos");	
        ) {
            int cod,nMusic; String titol; double preu; 
            while (rs.next())
            {
            	cod = rs.getInt(1);
            	titol = rs.getString(2);
            	preu = rs.getDouble("preu");
            	nMusic = rs.getInt("music");
            	System.out.println("Id: " + cod + ",\t" + titol + ", preu: " + preu + " euros, del músic " + nMusic);
            }
            
        } catch(SQLException se) {
            //Errors de JDBC
            se.printStackTrace();
        } 
    }
    
}
