package com.dam2.ut2empresamusica;

import java.sql.*;

public class ex2bUpdate
{
	public static void main(String args[])
	{
		try( Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/musica","root","root");
		Statement stmt = con.createStatement();)
		{
			String s = "update discos set preu = 20 where id > 1";
			int retorn = stmt.executeUpdate(s);
			System.out.println("El valor retornat per executeUpdate ha sigut " + retorn);
	
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
		}
	}
}
