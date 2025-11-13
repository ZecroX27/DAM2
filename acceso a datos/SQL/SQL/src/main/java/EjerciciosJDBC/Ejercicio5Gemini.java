package EjerciciosJDBC;
import java.sql.*;
import java.util.Scanner;

public class Ejercicio5Gemini {

    public static void main(String[] args) {

        // El Scanner SÍ debe estar en un try-with-resources
        try (Scanner sc = new Scanner(System.in);
             Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empresa2", "root", "root")) {

            // Ponemos el AutoCommit a false FUERA del try de la transacción
            conn.setAutoCommit(false);

            // Pedimos los datos al usuario
            System.out.println("Ingrese el id del empleado que transfiere:");
            int id_origen = sc.nextInt();
            System.out.println("Ingrese el id del empleado que recibe:");
            int id_destinatario = sc.nextInt();
            System.out.println("Introduce la cantidad de la transferencia:");
            double cantidad = sc.nextDouble();

            // Este es el bloque de la TRANSACCIÓN
            // Si algo falla aquí dentro, saltará al catch y hará rollback.
            try (PreparedStatement psOrigen = conn.prepareStatement("SELECT * FROM empleados WHERE id = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                 PreparedStatement psDestino = conn.prepareStatement("SELECT * FROM empleados WHERE id = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

                // 1. GESTIONAR EL ORIGEN
                psOrigen.setInt(1, id_origen);
                try (ResultSet rsOrigen = psOrigen.executeQuery()) {
                    rsOrigen.first();
                    double salarioOrigen = rsOrigen.getDouble("salario");
                    if (salarioOrigen < cantidad) {
                        throw new SQLException("El empleado no tiene saldo suficiente.");
                    }

                    // Actualizamos usando el ResultSet (eficiente)
                    rsOrigen.updateDouble("salario", salarioOrigen - cantidad);
                    rsOrigen.updateRow();
                }

                // 2. GESTIONAR EL DESTINATARIO
                psDestino.setInt(1, id_destinatario);
                try (ResultSet rsDestino = psDestino.executeQuery()) {
                    if (!rsDestino.first()) { // Comprobar si el empleado existe
                        throw new SQLException("El empleado de destino con ID " + id_destinatario + " no existe.");
                    }

                    double salarioDestino = rsDestino.getDouble("salario");

                    // Actualizamos usando el ResultSet
                    rsDestino.updateDouble("salario", salarioDestino + cantidad);
                    rsDestino.updateRow();
                }

                // 3. SI TODO HA IDO BIEN, HACEMOS COMMIT
                conn.commit();
                System.out.println("Transferencia completada con éxito.");

            } catch (SQLException e) {
                // Si algo falla (no hay saldo, un ID no existe),
                // 'conn' SÍ es visible aquí.
                System.err.println("ERROR en la transacción. Revirtiendo cambios...");
                conn.rollback(); // [cite: 1202]
                e.printStackTrace();
            }

        } catch (SQLException e) {
            // Este catch captura errores al *conectar* a la BBDD o al hacer el primer rollback
            System.err.println("Error de conexión a la Base de Datos.");
            e.printStackTrace();
        }
    }
}