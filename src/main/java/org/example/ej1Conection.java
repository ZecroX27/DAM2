package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ej1Conection {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pedidos", "root", "root")) {
            System.out.println("Conectado com sucesso " + con.getSchema());
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}