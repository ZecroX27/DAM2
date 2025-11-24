package EjerciciosJDBC;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

/*
4. ResultSet Actualizable. Haz una clase ConsultasUpdatable que incluya:

	- void actualizarSalariosViaResultSet(), incrementará un 10% cada salario inferior a 30000 euros usando updateRow()
	- void insertarEmpleadoViaResultSet(), insertará un nuevo empleado usando moveToInsertRow()
	- void eliminarEmpleadoViaResultSet(int id), eliminará un empleado usando deleteRow()
 */
public class Ejercicio4 {
    public static void main(String[] args) {

        try (Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empresa2", "root", "root")){
            Statement st = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("SELECT * FROM empleados");
            while (rs.next()) {
                if (rs.getDouble("salario") < 30000) {
                    rs.updateDouble("salario", rs.getDouble("salario") * 1.10);
                    rs.updateRow();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        try (Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empresa2", "root", "root");){
            Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from empleados ");
            rs.moveToInsertRow();
            rs.updateString("nombre", "Rodrigo");
            rs.updateString("apellido", "Rodrigo");
            rs.updateDouble("salario", 5000);
            rs.updateInt("departamento_id", 3);
            rs.updateDate("fecha_contratacion", Date.valueOf(LocalDate.now()));
            rs.updateBoolean("activo", true);
            rs.insertRow();
        }
        catch (SQLException e){
            e.printStackTrace();
        }


        try (Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empresa2", "root", "root")){
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM empleados WHERE id = ?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el ID del empleado a borrar");
            ps.setInt(1, sc.nextInt());
            ResultSet rs = ps.executeQuery();
            rs.first();
            rs.deleteRow();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
