package EjerciciosJDBC;

import java.sql.*;
import java.util.Scanner;

/*
5. Gestión de Transacciones. Haz una clase Transacciones que incluya:

	- void transferirSalario(int idEmpleadoOrigen, int idEmpleadoDestino, double cantidad),
	le restará una cantidad al empleado origen y se la sumará al empleado destino con sendas sentencias
	Update. Previamente comprobará quel el empleado origen tiene un salario superior a la cantidad a transferir
	- void actualizacionMasivaSalarios(), ejecutará un proceso por lotes con 3 sentencias Update que incrementen los salarios del departamento 1 un 5%, los del 2 un 3% y los del 3 un 2%. Debes utilizar addBatch() y executeBatch().

	Para ambas habrás de utilizar commit y rollback, haciendo setAutoCommit(false) inicialmente y volviendo a dejarlo en true al final.
 */
public class Ejercicio5 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empresa2", "root", "root");
        try {
            conn.setAutoCommit(false);
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el ID del empleado");
            int id_remitente = sc.nextInt();
            System.out.println("Introduce la cantidad a transferir");
            double cantidad = sc.nextDouble();
            System.out.println("Ingrese el id del destinatario ");
            int id_destinatario = sc.nextInt();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT salario FROM empleados WHERE id = "+id_remitente);
            rs.first();
            if (rs.getDouble("salario") > cantidad) {
                stmt.executeUpdate("UPDATE empleados SET salario = salario - "+cantidad+" WHERE id = "+id_remitente);
                stmt.executeUpdate("UPDATE empleados SET salario = salario + "+cantidad+" WHERE id = "+id_destinatario);
            }
            conn.commit();
        }
        catch (SQLException e){
            conn.rollback();
            e.printStackTrace();
        }
        finally{
            conn.setAutoCommit(true);
            conn.close();
        }
    }
}
