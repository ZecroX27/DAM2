package EjerciciosJDBC;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class OperacionesCRUD{
    static final private Connection conexion = Conexion.getConnection();

    public static void insertarEmpleado (String nombre,String apellido , Double salario, int departamento_id){
        try(
            Statement stmt = conexion.createStatement();){
            String sql = "INSERT INTO empleados (nombre, apellido, salario, departamento_id) values ('" +nombre + "', '" +apellido+ "'," +salario+"," +departamento_id+")";
            stmt.executeUpdate(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void listarEmpleados (){
        try(
            Statement stmt = conexion.createStatement();){
            String sql = "SELECT * FROM empleados";
            stmt.executeQuery(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void ActualizarSalario (int id, double nuevoSalario){
        try(
            Statement stmt = conexion.createStatement();){
            String sql = "UPDATE empleados SET salario = "+nuevoSalario+" WHERE empleados.id = "+id+"";
            stmt.executeUpdate(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void eliminarEmpleado (int id){
        try(
            Statement stmt = conexion.createStatement();){
            String sql = "DELETE FROM empleados WHERE empleados.id = "+id+"";
            stmt.executeUpdate(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }
}
class Result{
    public static void navegarResultSetForward(){

    }
    public static void navegarResultSetScrolleable(){

    }
}
