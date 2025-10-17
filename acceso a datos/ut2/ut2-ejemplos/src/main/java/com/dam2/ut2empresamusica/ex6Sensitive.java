package com.dam2.ut2empresamusica;/* Exemple de SELECT utilitzant RESULTSET per a comprovar que si és SENSITIVE: es voran les actualitzacions en el ResultSet
 */
import java.sql.*;

public class ex6Sensitive {
    
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
				if (cod == 5)
				{
					System.out.println("Pulsa INTRO para seguir");
					System.console().readLine();
					// mentre tant des de PHPMYADMIN CANVIE EL PREU DEL DISC I LI DONE A INTRO ...
					rs.refreshRow();
					// ... EL REFRESHROW() FA QUE ES DETECTEN ELS CANVIS
				}
            	titol = rs.getString(2);
            	preu = rs.getDouble("preu");
            	nMusic = rs.getInt("music");
            	System.out.println("Id: " + cod + ",\t" + titol + ", preu: " + preu + " euros, del music " + nMusic);
            }           
        } catch(SQLException se) {
            //Errores de JDBC
            se.printStackTrace();
        }
    }
    
}
