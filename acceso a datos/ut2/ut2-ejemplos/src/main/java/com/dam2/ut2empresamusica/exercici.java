package com.dam2.ut2empresamusica;/* EXERCICI PER A COMPLETAR PER PART DE L'ALUMNE */

import java.sql.*;
    
public class exercici {

        public static void main(String[] args) {
        // TODO code application logic here
        Connection conn = null;
        Statement stmt = null;
        /*
        try {
            //Registrando el Driver
            Registra el driver
            Class.forName(driver).newInstance();
            System.out.println("Driver "+driver+" Registrat correctament");
            
            //Abrir la conexi�n con la Base de Datos
            System.out.println("Connectando amb la Base de dades...");
            String jdbcUrl = "jdbc:mysql://localhost:3306/empresa";
            Abre la conexi�n con la base de datos
            System.out.println("Connexi� establerta amb la Base de dades...");
            
            
            //�s del m�tode executeQuery
            Crea objecte statement
            
            
            String sql = "update vendedores set salario=salario*0.90";
            
            executa ordee sql
            
            System.out.println(conn.getAutoCommit());
            
            canvia l'AutoCommit
            
            System.out.println(conn.getAutoCommit());
            
            sql = "update vendedores set salario=salario*1.10";

            executa ordre sql
            
            sql = "update articulos set precio=precio*1.05";

            executa ordre sql
            
            System.out.println("N�mero de files de venedors afectades "+files_venedors);
            System.out.println("N�ero de files de articles afectats "+files_articles);
            
            executa commit
            
            
        } catch(SQLException se) {
            //Errors de JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Errors de Class.forName
            e.printStackTrace();
        } finally {
            try {
                System.out.println("Fent rollback!");
                conn.rollback();

                //conn.setAutoCommit(true);
                
                
                if(stmt!=null)
                    stmt.close();

                if(conn!=null)
                    conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try  */
    }
    
}
