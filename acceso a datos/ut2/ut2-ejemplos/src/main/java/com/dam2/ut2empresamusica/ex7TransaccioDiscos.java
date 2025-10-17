package com.dam2.ut2empresamusica;/* Exemple de TRANSACCIÓ (TOT  O RES)
 */
import java.sql.*;
public class ex7TransaccioDiscos {

        public static void main(String[] args) {
        try ( Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/musica","root","root");)
	{
		try (Statement stmt = conn.createStatement();)
		{
		    // INICI DE LA TRANSACCIÓ
		    conn.setAutoCommit(false);
		    String sql = "insert into musics VALUES (4,'Duke Ellington','jazz')";
		    int valor = stmt.executeUpdate(sql);
		    if (valor == 0)
				throw new SQLException("La fila no s'ha pogut crear");
			sql = "select count(*) from discos where id=6";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			valor = rs.getInt(1);
			if (valor > 0)
				throw new SQLException("Eixa fila ja existeix");
		    sql = "insert into discos VALUES (6,'Take the A train',15,4)";
		    stmt.executeUpdate(sql);
		    // explícitament actualitze la base de dades amb commit()
		    conn.commit();
		    conn.setAutoCommit(true);
		}
		catch(SQLException se) {
			conn.rollback();
			conn.setAutoCommit(true);
			throw se;
		} 
	} 
	catch(SQLException e) {
		System.out.println(e.getMessage());
		} 
	}
}
