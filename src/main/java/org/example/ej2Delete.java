package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ej2Delete {
    public static void main(String[] args) {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://172.27.0.3:5432/pedidos", "root", "root");){
            Statement stmt = c.createStatement();
            String sql = "DELETE from categorias2  WHERE id = 1";
            int result = stmt.executeUpdate(sql);
            System.out.println("Se han borrado" + result + " filas");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
