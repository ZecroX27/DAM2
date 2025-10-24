package EjerciciosJDBC;

import java.sql.Statement;
import java.sql.*;

public class OperacionesCRUD {

    public static void insertarEmpleado (){
        try(Connection c = Conexion.getConnection();
            Statement stmt = c.createStatement();){
            String sql = "INSERT INTO empleados (nombre, apellido, salario, departamento_id) values ('Oscar', 'Carrillo', 1740.50, 3)";
            stmt.executeUpdate(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void listarEmpleados (){
        try(Connection c = Conexion.getConnection();
            Statement stmt = c.createStatement();){
            String sql = "SELECT * FROM empleados";
            stmt.executeQuery(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void ActualizarSalario (){
        try(Connection c = Conexion.getConnection();
            Statement stmt = c.createStatement();){
            String sql = "UPDATE empleados SET salario = 1230,45 WHERE empleados.nombre = 'Oscar'";
            stmt.executeUpdate(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void eliminarEmpleado (){
        try(Connection c = Conexion.getConnection();
            Statement stmt = c.createStatement();){
            String sql = "DELETE FROM empleados WHERE empleados.nombre = 'Oscar'";
            stmt.executeUpdate(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
