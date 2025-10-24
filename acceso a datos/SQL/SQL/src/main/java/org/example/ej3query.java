package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ej3query {
    public static void main(String[] args) {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://172.27.0.3:5432/pedidos", "root", "root");
             Statement stmt = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);){
            System.out.println("Conexion establecida con la base de datos");
            String sql = "SELECT * FROM categorias";
            ResultSet rs =  stmt.executeQuery(sql);
            int id; String descripcion;
            rs.afterLast();
            while (rs.previous()) {
                id = rs.getInt("categoriaid");
                descripcion = rs.getString("nombrecat");
                System.out.println("Id : "+ id  + " Descripcion : "+ descripcion);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
