package com.dam2.ut2empresamusica;/* Exemple de PROCESSAMENT PER LOTS (BATCH PROCESS)
 */
import java.sql.*;

public class ex9BatchDiscos {

        public static void main(String[] args) {
        try ( Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/musica","root","root");
        	Statement stmt = conn.createStatement();) {
		// INICI DEl PROCESSAMENT BATCH
		conn.setAutoCommit(false);
		String sql = "insert into musics VALUES (4,'Duke Ellington','jazz')";
		stmt.addBatch(sql);
		sql = "insert into discos VALUES (6,'Take the A train',4,15)";
		stmt.addBatch(sql);
		stmt.executeBatch();
		//  commit() manual
		conn.commit();		
        } catch(SQLException se) {
            //Errors de JDBC
            //conn.rollback();
        }

        	//conn.setAutoCommit(true);
    }
}
