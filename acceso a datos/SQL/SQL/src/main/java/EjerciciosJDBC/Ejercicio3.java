package EjerciciosJDBC;

import java.sql.*;

/*
3. Navegación con ResultSet No Actualizable. Haz una clase Consultas que incluya:
	- void navegarResultSetScrollable(), muestra el último, el primero, el tercero y todos en orden inverso, desde el final
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        try (Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empresa2", "root", "root");){
            Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select * from empleados ");
            rs.afterLast();
            rs.previous();
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            Double salario  = rs.getDouble("salario");
            int departamento = rs.getInt("departamento_id");
            Date fecha = rs.getDate("fecha_contratacion");
            boolean  activo = rs.getBoolean("activo");
            System.out.println(id + nombre + apellido + salario + departamento + fecha + activo);

            rs.beforeFirst();
            rs.next();
            id = rs.getInt("id");
            nombre = rs.getString("nombre");
            apellido = rs.getString("apellido");
            salario  = rs.getDouble("salario");
            departamento = rs.getInt("departamento_id");
            fecha = rs.getDate("fecha_contratacion");
            activo = rs.getBoolean("activo");
            System.out.println(id + nombre + apellido + salario + departamento + fecha + activo);

            rs.absolute(3);

            id = rs.getInt("id");
            nombre = rs.getString("nombre");
            apellido = rs.getString("apellido");
            salario  = rs.getDouble("salario");
            departamento = rs.getInt("departamento_id");
            fecha = rs.getDate("fecha_contratacion");
            activo = rs.getBoolean("activo");
            System.out.println(id + nombre + apellido + salario + departamento + fecha + activo);

            rs.afterLast();
            while(rs.previous()){
                id = rs.getInt("id");
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                salario  = rs.getDouble("salario");
                departamento = rs.getInt("departamento_id");
                fecha = rs.getDate("fecha_contratacion");
                activo = rs.getBoolean("activo");
                System.out.println(id + nombre + apellido + salario + departamento + fecha + activo);
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
