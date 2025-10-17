package com.dam2.ut2empresamusica;/* Exemple de TRANSACCIÓ (TOT  O RES)
 */
import java.sql.*;
public class ex7TransaccioEmpresa {
	
        public static void main(String[] args) {

        try ( Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empresa","root","root");    	)
         {
		try (Statement stmt = conn.createStatement();)
		{
			// INICI DE LA TRANSACCIÓ
			conn.setAutoCommit(false);
			String sql = "update articulos set precio = precio -20 where id = 2";
			int valor = stmt.executeUpdate(sql);
			if (valor == 0)
				throw new SQLException("La fila no existeix");
			// Si l'id no existeix no llança l'excepció: anem a forçar que la llance
			sql = "SELECT COUNT(*) FROM articulos WHERE id = 66";
			    ResultSet rs = stmt.executeQuery(sql);
			    rs.next();
			    valor = rs.getInt(1);
			    if (valor == 0) 
				throw new SQLException("La fila no existeix");
			
			sql = "update articulos set precio = precio + 20 where id = 66";
			stmt.executeUpdate(sql);
		}
		 catch(SQLException se) {
			conn.rollback();
			conn.setAutoCommit(true);
			throw se;
        	}
        	// explícitament actualitze la base de dades amb commit()
		conn.commit();
		conn.setAutoCommit(true);
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
    }
}
