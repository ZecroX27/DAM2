package EjercicosUT1;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

//2. Copia el contenido de un fichero en otro haciendo uso de los métodos estáticos de la clase Files de java.nio.
public class Ejercicio2 {
    public static void main(String[] args) {
        FileSystem fs = FileSystems.getDefault();
        Path path = fs.getPath("texto.txt");
        Path path2 = fs.getPath("textoCopiado.txt");
        try{
            Files.copy(path, path2, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Texto copiado correctamente");
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
