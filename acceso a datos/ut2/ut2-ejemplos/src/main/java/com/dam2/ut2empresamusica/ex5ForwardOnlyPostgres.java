package com.dam2.ut2empresamusica;

import java.sql.*;

public class ex5ForwardOnlyPostgres {

         public static void main(String[] args) {

        try ( Connection connexio = DriverManager.getConnection("jdbc:postgresql://172.18.0.2/coches","postgres","bitnami");
        	Statement stmt = connexio.createStatement();
        	ResultSet rs = stmt.executeQuery("select * from coches");	
        ) {
            
            System.out.println("Cursor abans de la primera fila? = "+ rs.isBeforeFirst());
            int id;
            String marca,model,matricula,dni;

            
            while (rs.next()) {
                //Obtenim la informació per el nom de la columna
                
                id = rs.getInt("id");
                marca = rs.getString("marca");
                model = rs.getString("modelo");
                
                //Obtenim la informació per l'index de la columna
                matricula = rs.getString(4);
                dni = rs.getString(5);
                

                //Mostrem la informació
                System.out.print("Número de Fila=" + rs.getRow());
                System.out.print(", id: " + id);
                System.out.print(", marca: " + marca);
                System.out.print(", model: " + model);
                System.out.print(", matrícula: " + matricula);
                System.out.println(", dni propietari: " + dni);
            }
            System.out.println("Cursor després de l'última fila? = " +rs.isAfterLast());    
            rs.first();        
        } catch(SQLException se) {
            //Errores de JDBC
            se.printStackTrace();
        }
    }
    
}
