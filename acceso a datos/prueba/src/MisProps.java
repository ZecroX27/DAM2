import java.io.*;
import java.util.Properties;

public class MisProps {
    public static void main(String[] args) {
        Properties prop = new Properties();
        //Guardamos los datos
        prop.setProperty("nombre", "Yoel");
        prop.setProperty("email", "yoel4352@gmail.com");
        prop.setProperty("telefono", "123456789");
        prop.setProperty(" ", " ");
        try{
            //Creamos el fichero de configuracion
            prop.store(new FileWriter("configuracion.props", true), "Fichero de configuracion");
        }
        catch (FileNotFoundException e){
            e.getMessage();
        }
        catch (IOException e){
            e.getMessage();
        }
        try {
            prop.load(new FileReader("configuracion.props"));
            String nombre = prop.getProperty("nombre");
            String email = prop.getProperty("email");
            String telefono = prop.getProperty("telefono");
            System.out.println("Nombre: " + nombre);
            System.out.println("Email: " + email);
            System.out.println("Telefono: " + telefono);
        }
        catch (IOException e){
            e.getMessage();
        }
    }
}
