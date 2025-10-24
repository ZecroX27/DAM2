package EjerciciosJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static String url = "jdbc:postgresql://localhost:5432/empresa2";
    private static String user = "root";
    private static String password = "root";
    public  static Connection getConnection(){
        try {
            return DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}


