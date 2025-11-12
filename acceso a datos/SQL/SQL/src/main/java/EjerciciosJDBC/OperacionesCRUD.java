package EjerciciosJDBC;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.time.LocalDate;

public class OperacionesCRUD{
    static final private Connection conexion = Conexion.getConnection();

    public static void insertarEmpleado (String nombre, String apellido , Double salario, int departamento_id){
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
    static private final Connection conn = Conexion.getConnection();
    public static void navegarResultSetForward() {

        String sql = "SELECT nombre, apellido, salario, departamento_id FROM empleados";

        try (Statement stmt = conn.createStatement();
             ResultSet st = stmt.executeQuery(sql)) {

            while (st.next()) {
                String nombre = st.getString("nombre");
                String apellido = st.getString("apellido");
                Double salario = st.getDouble("salario");
                int departamento = st.getInt("departamento_id");

                System.out.println("Empleado " + nombre + " " + apellido + " Salario " + salario + "  Departamento  " + departamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //- void navegarResultSetScrollable(), muestra el último, el primero, el tercero y todos en orden inverso, desde el final
    public static void navegarResultSetScrolleable(){
        String sql = "SELECT * FROM empleados";
        try (Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet st = stmt.executeQuery(sql);){
            //Muestro el ultimo de la consulta
            st.afterLast();
            st.previous();
            String nombre = st.getString("nombre");
            String apellido = st.getString("apellido");
            Double salario = st.getDouble("salario");
            int departamento = st.getInt("departamento_id");
            System.out.println(" Empleado " + nombre + " " + apellido + " Salario " + salario + " Departamento " + departamento);
            //Muestro el primero de la consulta
            st.beforeFirst();
            st.next();
            nombre = st.getString("nombre");
            apellido = st.getString("apellido");
            salario = st.getDouble("salario");
            departamento = st.getInt("departamento_id");
            System.out.println("Empleado " + nombre + " " + apellido + " Salario " + salario + " Departamento " + departamento);
            //Muestro el tercero de la consulta
            st.absolute(3);
            nombre = st.getString("nombre");
            apellido = st.getString("apellido");
            salario = st.getDouble("salario");
            departamento = st.getInt("departamento_id");
            System.out.println("Empleado " + nombre + " " + apellido + " Salario " + salario + " Departamento " + departamento);
            st.afterLast();
            while (st.previous()) {
                nombre = st.getString("nombre");
                apellido = st.getString("apellido");
                salario = st.getDouble("salario");
                departamento = st.getInt("departamento_id");
                System.out.println(" Empleado " + nombre + " " + apellido + " Salario " + salario + " Departamento " + departamento);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    /* ResultSet Actualizable. Haz una clase ConsultasUpdatable que incluya:

	- void actualizarSalariosViaResultSet(), incrementará un 10% cada salario inferior a 30000 euros usando updateRow()
	- void insertarEmpleadoViaResultSet(), insertará un nuevo empleado usando moveToInsertRow()
	- void eliminarEmpleadoViaResultSet(int id), eliminará un empleado usando deleteRow()
*/
    public static void actualizarSalariosViaResultSet(){
        String sql = "SELECT id,  salario FROM  empleados WHERE salario < 30000";
        try(Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            ResultSet st = stmt.executeQuery(sql)){

            while (st.next()) {
                    st.updateDouble("salario", st.getDouble("salario") * 1.10);
                    st.updateRow();

            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void insertarEmpleadosViaResultSet(){
        String sql = "SELECT * FROM empleados";
        try(Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sql);){
            rs.moveToInsertRow();
            rs.updateString("nombre", "Oscar");
            rs.updateString("apellido", "Carrillo");
            rs.updateDouble("salario", 30000);
            rs.updateInt("departamento_id", 1);
            LocalDate ld = LocalDate.parse("2025-12-06");
            java.sql.Date fechaSql = Date.valueOf(ld);
            rs.updateDate("fecha_contratacion", fechaSql );
            rs.updateBoolean("activo", true);
            rs.insertRow();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void eliminarEmpleadoViaResultSet(int id){
        String sql = "SELECT * FROM empleados";
        try(Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);){
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                if(rs.getInt("id") == id){
                    rs.deleteRow();
                }
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
   /* 5. Gestión de Transacciones. Haz una clase Transacciones que incluya:
    - void transferirSalario(int idEmpleadoOrigen, int idEmpleadoDestino, double cantidad), le restará una cantidad al empleado origen y se la sumará al empleado destino con sendas sentencias Update. Previamente comprobará quel el empleado origen tiene un salario superior a la cantidad a transferir
	- void actualizacionMasivaSalarios(), ejecutará un proceso por lotes con 3 sentencias Update que incrementen los salarios del departamento 1 un 5%, los del 2 un 3% y los del 3 un 2%. Debes utilizar addBatch() y executeBatch().
       Para ambas habrás de utilizar commit y rollback, haciendo setAutoCommit(false) inicialmente y volviendo a dejarlo en true al final.
    */

}
class Transacciones{
    static private final Connection conn = Conexion.getConnection();
    public static void  transferirSalario(int idEmpleadoOrigen, int idEmpleadoDestino, double cantidad){
        String sql = "SELECT salario FROM empleados WHERE id=" + idEmpleadoOrigen; // "SELECT empleados SET salario= salario - "+cantidad+" WHERE id_empleado="+idEmpleadoOrigen;
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);){
            conn.setAutoCommit(false);
            rs.next();
            if(rs.getDouble("salario") >= cantidad){
                stmt.executeUpdate("UPDATE empleados SET salario= salario - "+cantidad+" WHERE id="+idEmpleadoOrigen);
                stmt.executeUpdate("UPDATE empleados SET salario= salario + "+cantidad+" WHERE id="+idEmpleadoDestino);
            }
            conn.commit();
        }
        catch(SQLException e){
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.getCause();
            }
            e.printStackTrace();

        }
        finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.getMessage();
            }
        }
    }

    public static void actualizacionMasivaSalarios() throws SQLException{

        try(Statement stmt = conn.createStatement();){
            conn.setAutoCommit(false);
            String sql = "UPDATE empleados SET salario = salario *1.05 WHERE departamento_id= 1";
            stmt.addBatch(sql);
            sql = "UPDATE empleados SET salario = salario *1.03 WHERE departamento_id= 2";
            stmt.addBatch(sql);
            sql = "UPDATE empleados SET salario = salario *1.02 WHERE departamento_id= 3";
            stmt.addBatch(sql);
            stmt.executeBatch();
            conn.commit();
        }
        catch(SQLException e){
            conn.rollback();
            e.printStackTrace();
        }
        finally {
            conn.setAutoCommit(true);
        }
    }
}


/*6. PreparedStatement y Operaciones Parametrizadas. El objetivo será mejorar la sseguridad y el rendimiento por usar PreparedStatement con parámetros ?. Haz una clase EmpleadosPreparedStatement que incluya:

    - void insertarEmpleadoPrepared(String nombre, String apellido, double salario, int departamentoId), los cuatro valores serán parámetros para PreparedStatement.
    - void buscarEmpleadosPorDepartamento(int departamentoId), ejecutará una sentencia precompilada con el identificador del departamento como único parámetro. Mostrará por pantalla los datos de los empleados del departamento indicado.
	- void actualizarSalarioPrepared(int id, double nuevoSalario), ejecutará un Update con los dos parámetro indicados para cambiar el salario de ese empleado.
*/
class EmpleadosPreparedStatement{
    static private final Connection conn = Conexion.getConnection();
    public static void insertarEmpleadoPrepared(String nombre, String apellido, double salario, int departamentoId){
        try(PreparedStatement pstmt = conn.prepareStatement("INSERT INTO empleados (nombre, apellido, salario, departamento_id) VALUES (?, ?, ?, ?)");){
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setDouble(3, salario);
            pstmt.setInt(4, departamentoId);
            pstmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
    public static void buscarEmpleadosPorDepartamento(int departamentoId){
        try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM empleados WHERE departamento_id = ? ;");) {
            pstmt.setInt(1, departamentoId);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String nombre =  rs.getString("nombre");
                String apellido = rs.getString("apellido");
                Double salario = rs.getDouble("salario");
                int departamento= rs.getInt("departamento_id");
                System.out.println("nombre: "+nombre+ " apellido: "+apellido+" salario: "+salario+" departamento: "+departamento);
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void actualizarSalarioPrepared(int id, double nuevoSalario){
        try (PreparedStatement pstmt = conn.prepareStatement("UPDATE empleados SET salario = ? WHERE id = ?");){
            pstmt.setDouble(1, nuevoSalario);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

}