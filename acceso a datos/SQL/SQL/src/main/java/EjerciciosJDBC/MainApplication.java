package EjerciciosJDBC;

import java.sql.SQLException;

public class MainApplication  {
    public static void main(String[] args)throws SQLException {
        Conexion conexion = new Conexion();
        OperacionesCRUD operacionesCRUD = new OperacionesCRUD();
        //operacionesCRUD.insertarEmpleado("Iker","Galinsoga", 1750.50, 3);
        //Result.navegarResultSetScrolleable();
        //Result.actualizarSalariosViaResultSet();
        //Result.insertarEmpleadosViaResultSet();
        //Result.eliminarEmpleadoViaResultSet(9);
        Transacciones transacciones = new Transacciones();
        //transacciones.transferirSalario(1, 2, 500);
        //transacciones.actualizacionMasivaSalarios();
        Result.navegarResultSetForward();
    }
}
