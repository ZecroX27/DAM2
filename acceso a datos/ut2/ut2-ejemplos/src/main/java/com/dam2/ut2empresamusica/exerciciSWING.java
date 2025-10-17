package com.dam2.ut2empresamusica;/* Exercici QUE MOSTRE TOTS ELS DISCOS, PERO CONSULTANT-LOS INDIVIDUALMENTE, DE UN EN UN, ENDAVANT O CAP ARRERE (AMB PROGRAMACIÓ VISUAL)
 */
import java.sql.*;

public class exerciciSWING {
    
    public static void main(String[] args) {
	/* AFIG AQUÍ ELS COMPONENTS SWING NECESSARIS, JFRAME, JPANEL/S AMB EL SEU CORRESPONENT LAYOUT, JLABELS, JTEXTfIELDS I jBUTTONS
	 *
		TAMBÉ AFIC EL PANELL O PANELLS A LA FINESTRA, I ELS COMPONENTS AL SEU PANELL

	APART DEL BOTÓ DE CONNECTAR, HA DE HAVER DOS BOTONS ---> Y <---- PER A AVANÇAR I RETROCEDIR PER CADASCUN DELS DISCOS

*/

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //Registrant el Driver
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver).newInstance();
            System.out.println("Driver "+driver+" Registrat correctament");
            
           
            // Obrir la connexión amb la Base de Dades
            System.out.println("Connectant amb la Base de dades...");
            String jdbcUrl = "jdbc:mysql://localhost:3306/discos";
            conn = DriverManager.getConnection(jdbcUrl,"root","");
            System.out.println("Connexió establerta amb la Base de dades...");

            // AQUÍ HAS D'ELIMINAR LA LIMITACIÓ DE FORWARD_ONLY, HAURÀS D'UTILIZAR TYPE_SCROLL_INSENSITIVE (O SENSITIVE TAMBÉ VAL)
            
            stmt = conn.createStatement();

            String sql = "SELECT * FROM discos where preu > 15";
            rs = stmt.executeQuery(sql);	// obtinc el conjunt de resultats de discos
            int cod,nMusic; String titol; double preu; 

	    /* A PARTIR D'AQUÍ EL CODI QUE AVANCE O RETROCEDISCA SOBRE EL RESULTSET HA DE ANAR DINTRE DEL ACTIONPERFORMED PER ALS LISTENERS DELS BOTONS ---> I <----, NO DEU  HAVER BUCLE, AMB CADA CLIC DEL BOTÓ ES FARÀ UN next() O UN PREVIOUS
	     * ELS GETINT, GETSTRING ... SERAN IGUAL, PERÒ AL FINAL EIXOS VALORES S'HAN DE POSAR EN ELS JTEXTFIELD CORRESPONENTS
	     * */
            while (rs.next())
            {
            	cod = rs.getInt(1);
            	titol = rs.getString(2);
            	preu = rs.getDouble("preu");
            	nMusic = rs.getInt("music");
            	System.out.println("Id: " + cod + ",\t" + titol + ", preu: " + preu + " euros, del music " + nMusic);
            }
        } catch(SQLException se) {
            //Errores de JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Errores de Class.forName
            e.printStackTrace();
        } finally {
		// AQUESTA PART HAURIA DE FER-SE AL TANCAR LA FINESTRA (EXIT_ON_CLOSE?) RECORDA QUE TAMBÉ ES POT CAPTURAR L'ESDEVENIMENT DEL TANCAMENT DE LA FINESTRA 
            try {
            	if (rs != null)
            		rs.close();
                if(stmt!=null)
                    stmt.close();                
                if(conn!=null)
                    conn.close();
                System.out.println("Connexió tancada");
            } catch(SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try  
    }
    
}
