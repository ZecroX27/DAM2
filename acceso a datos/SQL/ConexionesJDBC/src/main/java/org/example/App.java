package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App 
{
    public static void main( String[] args )
    {
        try ( Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pedidos", "root", "root");){

            System.out.println("Connected to database successfully" + conexion.getSchema());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
