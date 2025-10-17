import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 2. Copia el contenido de un fichero en otro haciendo uso de los metodos estatticos de la clase files en java.nio*/
public class ejercicio2 {
    public static void main(String[] args) {
        Path origen = Paths.get("texto ej2.txt");
        Path destino = Paths.get("texto2 ej2.txt");
        try{
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException e){
            e.getMessage();
        }
    }
}
