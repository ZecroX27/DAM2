package EjerciciosJDBC;

import java.sql.SQLException;

public class MainApplication  {
    public static void main(String[] args)throws SQLException {
        Conexion conexion = new Conexion();
        OperacionesCRUD operacionesCRUD = new OperacionesCRUD();
        //operacionesCRUD.listarEmpleados();
        //Result.navegarResultSetScrolleable();
        //Result.actualizarSalariosViaResultSet();
        //Result.insertarEmpleadosViaResultSet();
        //Result.eliminarEmpleadoViaResultSet(9);
        Transacciones transacciones = new Transacciones();
        //transacciones.transferirSalario(1, 2, 500);
        //transacciones.actualizacionMasivaSalarios();
        //EmpleadosPreparedStatement.insertarEmpleadoPrepared("Oscar", "Galinsoga", 30000.00, 3);
        //EmpleadosPreparedStatement.buscarEmpleadosPorDepartamento(3);
        EmpleadosPreparedStatement.actualizarSalarioPrepared(6, 25000);
        //Result.navegarResultSetForward();
    }
}
