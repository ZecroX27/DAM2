package EjerciciosJDBC;

import java.sql.*;
import java.util.Scanner;

/*
2. Operaciones CRUD (CREATE, READ, UPDATE, DELETE) básicas con Statement. Haz una clase EmpleadosCrud que incluya los métodos:

	- void insertarEmpleado(String nombre, String apellido, double salario, int departamentoId)
	- void listarEmpleados()
	- void actualizarSalario(int id, double nuevoSalario)
	- void eliminarEmpleado(int id)
 */
public class Ejercicio2 {
    public static void main(String[] args) {

        try (Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empresa2", "root", "root");){
            System.out.println("Conexion establecida!");

            String sql = "INSERT INTO empleados (nombre, apellido, salario, departamento_id) VALUES ( ?, ?, ?, ?)";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el nombre del empleado");
            String nombre = sc.nextLine();
            System.out.println("Ingrese el apellido del empleado");
            String apellido = sc.nextLine();
            System.out.println("Ingrese el salario del empleado");
            double salario = sc.nextDouble();
            System.out.println("Ingrese el departamento del empleado");
            int departamento = sc.nextInt();
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setDouble(3, salario);
            pstmt.setInt(4, departamento);
            pstmt.executeUpdate();
            System.out.println("El empleado se ha registrado correctamente");
        }
        catch (SQLException e){
            e.printStackTrace();
        }



        try (Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empresa2", "root", "root");){
            System.out.println("Conexion establecida!");
            Statement stmt = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM empleados");
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                double salario = rs.getDouble("salario");
                int departamento = rs.getInt("departamento_id");
                System.out.println(nombre + " " + apellido + " " + salario + " " + departamento);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }



        try (Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empresa2", "root", "root");){
            System.out.println("Conexion establecida!");
            PreparedStatement stmt = conexion.prepareStatement("UPDATE empleados SET salario = ? WHERE id = ?");
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el id del empleado que quieras cambiar el salario");
            int id = sc.nextInt();
            System.out.println("Introduce el salario nuevo del empleado");
            double salario = sc.nextDouble();
            stmt.setDouble(1, salario);
            stmt.setInt(2, id);
            stmt.executeUpdate();

        }
        catch (SQLException e){
            e.printStackTrace();
        }


        try (Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empresa2", "root", "root");){
            PreparedStatement stmt = conexion.prepareStatement("DELETE FROM empleados WHERE id = ?");
            Scanner teclado = new Scanner(System.in);
            System.out.println("Ingrese el id del empleado a borrar");
            stmt.setInt(1, teclado.nextInt());
            stmt.
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

}

