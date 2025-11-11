package EjerciciosJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String url = "jdbc:postgresql://localhost:5432/empresa2";
    private static final String user = "root";
    private static final String password = "root";
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


