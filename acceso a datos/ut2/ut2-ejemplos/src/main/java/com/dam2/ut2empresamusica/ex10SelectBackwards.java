package com.dam2.ut2empresamusica;/* Exemple de SELECT utilitzant RESULTSET mostrant el contingut de la taula en sentit invers
 */
import java.sql.*;

public class ex10SelectBackwards {
    
    public static void main(String[] args) {
           // CREANT UN OBJECTE STATEMENT SENSE RESTRICCIÓ DE MOVIMENTS I QUE PERMETA RETROCEDIR 
           //String jdbcUrl = "jdbc:mysql://localhost/discos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
           
        try ( Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/musica","root","root");
        	Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_READ_ONLY);
        	ResultSet rs = stmt.executeQuery("select * from discos");	
        ) {
            int cod,nMusic; String titol; double preu; 
	    rs.afterLast();	// em posicione al final
            while (rs.previous())
            {
            	cod = rs.getInt(1);
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
